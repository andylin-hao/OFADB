package result;

import expression.select.ResultColumnExpr;
import expression.select.SelectExpr;
import expression.select.SubSelectExpr;
import types.ResultType;

import java.io.IOException;
import java.util.*;

public class QueryResult extends Result {
    private QueryResult[] subResult;

    private QueryResult basedResult;
    ArrayList<ArrayList<String>> datas;
    private LinkedHashMap<String, ResultColumnExpr> selectColumns = null;

    private static String finalResultName = "result";

    public void setFinalResult(boolean finalResult) {
        isFinalResult = finalResult;
    }

    public void setIterable() {
        this.next = 0;
    }

    private boolean isFinalResult = false;
    private int next = 0;

    public SubSelectExpr getSelectExpr() {
        return selectExpr;
    }

    public QueryResult getBasedResult() {
        return basedResult;
    }

    public void setSelectExpr(SubSelectExpr selectExpr) {
        this.selectExpr = selectExpr;
    }

    private SubSelectExpr selectExpr;

    QueryResult() {
        super(ResultType.RESULT_QUERY);
        subResult = null;
        basedResult = null;
        selectExpr = null;
    }

    public QueryResult(QueryResult base) {
        super(ResultType.RESULT_QUERY);
        basedResult = base;
        datas = new ArrayList<>();
        subResult = null;
        this.selectExpr = null;
    }

    public QueryResult(QueryResult base, SubSelectExpr tableExpr) {
        super(ResultType.RESULT_QUERY);
        basedResult = base;
        datas = new ArrayList<>();
        subResult = null;
        this.selectExpr = tableExpr;
    }

    public QueryResult(QueryResult r1, QueryResult r2) {
        super(ResultType.RESULT_QUERY);
        basedResult = null;
        subResult = getMergedSubResultArray(r1, r2);
        datas = new ArrayList<>();
        this.selectExpr = null;
    }

    public ArrayList<ArrayList<String>> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<ArrayList<String>> datas) {
        this.datas = datas;
    }


    public void insert(ArrayList<String> data) {
        this.datas.add(data);
    }


    private QueryResult[] getMergedSubResultArray(QueryResult r1, QueryResult r2) {
        QueryResult[] r1Array;
        QueryResult[] r2Array;
        if (r1.subResult == null) {
            r1Array = new QueryResult[1];
            r1Array[0] = r1;
        } else {
            r1Array = r1.subResult;
        }
        if (r2.subResult == null) {
            r2Array = new QueryResult[1];
            r2Array[0] = r2;
        } else {
            r2Array = r2.subResult;
        }

        QueryResult[] merged = new QueryResult[r1Array.length + r2Array.length];
        System.arraycopy(r1Array, 0, merged, 0, r1Array.length);
        System.arraycopy(r2Array, 0, merged, r1Array.length, r2Array.length);
        return merged;

    }


    /**
     * return the actual data of the insert position,if the result is a finish version of a select expression ,then it return the data of select sub-expresion
     * else it return the hole data of all table involved
     *
     * @param positions the positions of this line in different sub-result
     */
    public SingleResult getValue(ArrayList<String> positions) throws IOException {
        if (!isFinalResult) {
            if (basedResult == null) {
                SingleResult result = new SingleResult();
                for (int i = 0; i < subResult.length; i++) {
                    SingleResult subSingle = subResult[i].getValue(positions.get(i));
                    result.merge(subSingle);
                }
                return result;
            } else {
                return getValue(positions.get(0));
            }
        } else {
            if (subResult != null) {
                SingleResult result = new SingleResult();
                for (int i = 0; i < subResult.length; i++) {
                    SingleResult subSingle = subResult[i].getValue(positions.get(i));
                    result.merge(subSingle);
                }
                HashMap<String, Object> data = new HashMap<>();
                for (Map.Entry<String, ResultColumnExpr> ele : selectColumns.entrySet()) {
                    String columnName = ele.getKey();
                    Object object = result.getValue(ele.getValue());
                    data.put(columnName, object);
                }
                String index = String.valueOf(this.datas.indexOf(positions));
                if (selectExpr != null)
                    return new SingleResult(index, selectExpr.getRangeTableName(), data);
                else
                    return new SingleResult(index, QueryResult.finalResultName, data);
            } else {
                return getValue(positions.get(0));
            }
        }
    }


    /**
     * return the data with the input index in the datas list
     *
     * @param position the index of the line in datas
     */
    public SingleResult getValue(String position) throws IOException {
        if (basedResult != null) {
            SingleResult baseResult = basedResult.getValue(basedResult.datas.get(Integer.parseInt(position)));
            //if the select is based on just one table
            if (isFinalResult) {
                HashMap<String, Object> data = new HashMap<>();
                for (Map.Entry<String, ResultColumnExpr> ele : selectColumns.entrySet()) {
                    String columnName = ele.getKey();
                    Object object = baseResult.getValue(ele.getValue());
                    data.put(columnName, object);
                }
                if (selectExpr != null)
                    return new SingleResult(position, selectExpr.getRangeTableName(), data);
                else
                    return new SingleResult(position, QueryResult.finalResultName, data);
            }
            return baseResult;
        } else {
            return getValue(datas.get(Integer.parseInt(position)));
        }
    }

    public SingleResult getValue(int position) throws IOException {
        if (basedResult != null)
            return basedResult.getValue(basedResult.datas.get(position));
        else {
            return getValue(datas.get(position));
        }
    }


    public HashMap<String, ResultColumnExpr> getSelectColumns() {
        return selectColumns;
    }

    public void setSelectColumns(SelectExpr expr) {
        this.selectColumns = new LinkedHashMap<>();
        for (ResultColumnExpr columnExpr : expr.getResultColumnExprs()) {
            this.selectColumns.put(columnExpr.getTableName()+"."+columnExpr.getName(), columnExpr);
        }
    }

    public String[] getColumnNames() {
        String[] names = new String[this.selectColumns.size()];
        return this.selectColumns.keySet().toArray(names);
    }

    public boolean hasNext() {
        return next < datas.size();
    }

    public Object[] next() throws IOException {
        if (isFinalResult) {
            if (next < this.datas.size()) {
                int pos = next++;
                SingleResult singleResult = getValue(datas.get(pos));
                String[] names = getColumnNames();
                Object[] data = new Object[names.length];
                Map<String, Object> result = singleResult.getDatas().get(QueryResult.finalResultName);
                for (int i = 0; i < data.length; i++)
                    data[i] = result.get(names[i]);
                return data;
            } else
                throw new RuntimeException("No more data in the result");
        } else
            throw new RuntimeException("This is not a complete result of a select ");
    }
}
