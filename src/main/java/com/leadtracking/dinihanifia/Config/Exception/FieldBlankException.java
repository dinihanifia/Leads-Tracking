package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class FieldBlankException extends RuntimeException{
    public FieldBlankException(){
        super(MessageConstant.FIELD_IS_NULL);
    }
}
