package com.leadtracking.dinihanifia.POJO.Request;
import com.leadtracking.dinihanifia.Annotations.EmailValidation;
import com.leadtracking.dinihanifia.Annotations.NamaValidation;
import com.leadtracking.dinihanifia.Annotations.NomorTeleponValidation;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BaseRequest {
    @NamaValidation(min = 3, max = 60)
    private String nama;
    @EmailValidation
    private String email;
    @NomorTeleponValidation
    private String nomorTelepon;
}
