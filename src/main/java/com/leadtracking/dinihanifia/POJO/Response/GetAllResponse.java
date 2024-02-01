package com.leadtracking.dinihanifia.POJO.Response;
import com.leadtracking.dinihanifia.POJO.Model.Lead;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetAllResponse {
    private int responseCode;
    private String responseMessage;
    private List<Lead> leads;
}
