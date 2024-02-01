package com.leadtracking.dinihanifia.Config.Exception;

import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class DuplicateNoTeleponException extends RuntimeException{
    public DuplicateNoTeleponException(String nomorTelepon){
        super(MessageConstant.DUPLICATE_NO_TELEPON);
    }
}
