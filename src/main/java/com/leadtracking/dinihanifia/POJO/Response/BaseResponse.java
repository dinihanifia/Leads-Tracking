package com.leadtracking.dinihanifia.POJO.Response;
import com.leadtracking.dinihanifia.POJO.Model.Lead;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {
    private int responseCode;
    private String responseMessage;
    private Lead lead;
}
