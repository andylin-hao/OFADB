package result;

import block.BlockInfo;
import disk.System;
import disk.Table;
import expression.select.RangeTableExpr;
import expression.select.RelationExpr;
import expression.select.ResultColumnExpr;
import types.ResultType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class QueryResult extends Result {
    private QueryResult[] subResult;
    private RelationExpr tableExpr;
    private ArrayList<ArrayList<String>> datas;
    private HashMap<String,ResultColumnExpr> selectColumns;

    public QueryResult(RelationExpr table) throws IOException{
        super(ResultType.RESULT_QUERY);
        subResult = null;
        selectColumns = null;
        this.tableExpr = table;
        datas = new ArrayList<>();
        initResultByTable();
    }

    public void initResultByTable()throws IOException {
        String databaseName = tableExpr.getDbName();
        String tableName = tableExpr.getTableName();
        Table table = Objects.requireNonNull(System.getDataBase(databaseName)).getTable(tableName);
        List<BlockInfo> blockInfos = table.dataFileManager.blockInfos;
        for(int i = 0;i<blockInfos.size();i++){
            for(int j = 0;j<blockInfos.get(i).emptyRecord.size();j++)
                if(blockInfos.get(i).emptyRecord.get(j)) {
                    ArrayList<String> data = new ArrayList<>();
                    data.add(i + ","+ j);
                    datas.add(data);
                }
        }

    }

    public void insert(ArrayList<String> data){
        this.datas.add(data);
    }

    public SingleResult getValue(String position)throws IOException{
        if(tableExpr != null){
                String databaseName = tableExpr.getDbName();
                String tableName = tableExpr.getTableName();
                Table table = Objects.requireNonNull(System.getDataBase(databaseName)).getTable(tableName);
                String[] br = position.split(",");
                int blockIndex = Integer.valueOf(br[0]);
                int rowIndex = Integer.valueOf(br[1]);
                Object[] rowData = table.dataFileManager.get(blockIndex, rowIndex).rowData;
                HashMap<String, Object> data = new HashMap<>();
                for (int i = 0; i < table.info.columns.length; i++)
                    data.put(table.info.columns[i].columnName, rowData[i]);
                return new SingleResult(position, tableExpr.getName(), data);
        }
        else{
            ArrayList<String> positions = datas.get(Integer.valueOf(position));
            SingleResult result = new SingleResult();
            for(int i = 0;i<subResult.length;i++){
                SingleResult subSingle = subResult[i].getValue(positions.get(i));
                result.merge(subSingle);
            }
            return result;
        }
    }

    public Object getColumnValue(String column,String position)throws IOException{
        if(tableExpr != null){
            SingleResult holeData = this.getValue(position);
            String tableName = tableExpr.getName();
            return holeData.getValue(column,tableName);
        }
        else{
            ResultColumnExpr columnExpr = selectColumns.get(column);
            SingleResult holeData = this.getValue(position);
            String tableName = tableExpr.getName();
            return holeData.getValue(columnExpr);
        }
    }


}
