package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String email){
        super(MessageConstant.DUPLICATE_EMAIL);
    }
}
