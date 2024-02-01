package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException(){
        super(MessageConstant.EMAIL_NOT_VALID);
    }
}
