package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class InvalidNamaException extends RuntimeException{
    public InvalidNamaException(){
        super(MessageConstant.BAD_REQUEST);
    }
}
