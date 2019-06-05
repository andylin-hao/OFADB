package result;

import expression.select.ResultColumnExpr;

import java.util.ArrayList;
import java.util.HashMap;

public class SingleResult {
    private ArrayList<String> positions = new ArrayList<>();

    public ArrayList<String> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<String> positions) {
        this.positions = positions;
    }

    public HashMap<String, HashMap<String, Object>> getDatas() {
        return datas;
    }

    public void setDatas(HashMap<String, HashMap<String, Object>> datas) {
        this.datas = datas;
    }

    private HashMap<String, HashMap<String, Object>> datas = new HashMap<>();

    public SingleResult(String position, String tableName, HashMap<String, Object> data) {
        positions.add(position);
        datas.put(tableName, data);
    }

    public SingleResult() {

    }

    public SingleResult(SingleResult r1, SingleResult r2) {
        this.positions.addAll(r1.positions);
        this.positions.addAll(r2.positions);
        this.datas = new HashMap<>();
        this.datas.putAll(r1.datas);
        this.datas.putAll(r2.datas);
    }

    public void merge(SingleResult another) {
        positions.addAll(another.positions);
        datas.putAll(another.datas);
    }

    public Object getValue(ResultColumnExpr expr) {
        String tableName = expr.getTableName();
        String columnName = expr.getAttrName();
        return getValue(columnName, tableName);
    }

    public Object getValue(String columnName, String tableName) {
        return datas.get(tableName).get(columnName);
    }

    public static SingleResult merge(SingleResult r1, SingleResult r2) {
        SingleResult result = new SingleResult();
        result.getPositions().addAll(r1.getPositions());
        result.getPositions().addAll(r2.getPositions());
        result.getDatas().putAll(r1.getDatas());
        result.getDatas().putAll(r2.getDatas());
        return result;
    }
}
