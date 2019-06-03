package types;

import java.io.Serializable;

public enum MsgTypes implements Serializable {
    MSG_RES_ERR,
    MSG_RES_SUCCESS,
    MSG_POST_SQL,
    MSG_POST_CONNECT
}
