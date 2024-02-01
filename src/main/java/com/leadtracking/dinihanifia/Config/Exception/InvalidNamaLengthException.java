package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class InvalidNamaLengthException extends RuntimeException{
    public InvalidNamaLengthException(){
        super(MessageConstant.LENGTH_NAMA_NOT_VALID);
    }
}
