package com.leadtracking.dinihanifia.Config.Exception;

import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class InvalidNoTeleponException extends RuntimeException{
    public InvalidNoTeleponException(){
        super(MessageConstant.NO_TELEPON_NOT_VALID);
    }
}
