package server;

import types.MsgTypes;

import java.io.Serializable;

public class PostData implements Serializable {
    public MsgTypes type;
    public String userName;
    public String password;
    public String sql;
}
