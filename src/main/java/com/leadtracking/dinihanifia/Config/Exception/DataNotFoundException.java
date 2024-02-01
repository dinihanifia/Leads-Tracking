package com.leadtracking.dinihanifia.Config.Exception;

import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;

import java.util.UUID;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(){
        super(MessageConstant.LEAD_IS_NOT_FOUND);
    }
}
