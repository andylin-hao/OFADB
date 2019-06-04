package result;

import types.ResultType;

public class MsgResult extends Result {
    private String msg;
    public MsgResult(String msg){
        super(ResultType.RESULT_MSG);
        this.msg = msg;
    }
    public String getMsg() { return msg; }
}
