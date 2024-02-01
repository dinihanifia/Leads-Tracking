package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;
import java.util.UUID;

public class LeadIDNotFoundException extends RuntimeException{
    public LeadIDNotFoundException(UUID leadId){
        super(MessageConstant.LEAD_ID_IS_NOT_FOUND);
    }
}
