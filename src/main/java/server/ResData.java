package server;

import types.MsgTypes;

import java.io.Serializable;

public class ResData implements Serializable {
    public MsgTypes type;
    public String message;
    public TableData tableData;
    public double time;
}
