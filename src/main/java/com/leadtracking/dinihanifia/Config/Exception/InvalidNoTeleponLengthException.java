package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class InvalidNoTeleponLengthException extends RuntimeException{
    public InvalidNoTeleponLengthException(){
        super(MessageConstant.LENGTH_NO_TELEPON_NOT_VALID);
    }
}
