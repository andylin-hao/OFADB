package server;

import java.io.Serializable;
import java.util.ArrayList;

public class TableData implements Serializable {
    public String[] columnNames;
    public ArrayList<Object[]> data = new ArrayList<>();
}
