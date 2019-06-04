package result;

import server.TableData;
import types.ResultType;

import java.util.ArrayList;

public class InfoResult extends Result {
    private TableData tableData = new TableData();

    public InfoResult(String name, ArrayList<String> infos){
        super(ResultType.RESULT_INFO);
        this.tableData.columnNames = new String[1];
        this.tableData.columnNames[0] = name;

        this.tableData.data = new ArrayList<>();
        for(String info : infos)
        {
            Object[] objects = new Object[1];
            objects[0] = info;
            this.tableData.data.add(objects);
        }
    }
    public TableData getTableData() {
        return tableData;
    }

}
