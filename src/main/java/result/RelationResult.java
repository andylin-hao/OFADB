package result;

import block.BlockInfo;
import disk.System;
import disk.Table;
import expression.select.RelationExpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class RelationResult extends QueryResult{
    private RelationExpr tableExpr;
    public RelationResult(RelationExpr table) {
        super();
        this.tableExpr = table;
        datas = new ArrayList<>();
        initResultByTable();
    }

    public String getName() {
        return tableExpr.getName();
    }
    private void initResultByTable(){
        String tableName = tableExpr.getTableName();
        Table table = Objects.requireNonNull(System.getCurDB().getTable(tableName));
        List<BlockInfo> blockInfos = table.dataFileManager.blockInfos;
        for(int i = 0;i<blockInfos.size();i++){
            for(int j = 0;j<blockInfos.get(i).emptyRecord.size();j++)
                if(!blockInfos.get(i).emptyRecord.get(j)) {
                    ArrayList<String> data = new ArrayList<>();
                    data.add(i + ","+ j);
                    datas.add(data);
                }
        }
    }

    @Override
    public SingleResult getValue(String position) throws IOException {
        String tableName = tableExpr.getTableName();
        Table table = Objects.requireNonNull(System.getCurDB().getTable(tableName));

        String[] br = position.split(",");
        int blockIndex = Integer.valueOf(br[0]);
        int rowIndex = Integer.valueOf(br[1]);

        Object[] rowData = table.dataFileManager.get(blockIndex, rowIndex).rowData;
        HashMap<String, Object> data = new HashMap<>();
        for (int i = 0; i < table.info.columns.length; i++)
            data.put(table.info.columns[i].columnName, rowData[i]);
        return new SingleResult(String.valueOf(datas.indexOf(new ArrayList<String>(){{add(position);}})), tableExpr.getName(), data);
    }

    @Override
    public SingleResult getValue(ArrayList<String> positions) throws IOException {
        String position = positions.get(0);
        return getValue(position);
    }
}
