package com.leadtracking.dinihanifia.Controller;
import com.leadtracking.dinihanifia.Config.Constant.URLConstant;
import com.leadtracking.dinihanifia.POJO.Request.BaseRequest;
import com.leadtracking.dinihanifia.POJO.Response.BaseResponse;
import com.leadtracking.dinihanifia.POJO.Response.GetAllResponse;
import com.leadtracking.dinihanifia.Service.LeadService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lead")
@Validated
public class MainController {
    private final LeadService leadService;
    @Operation(summary = "Get All List of Leads")
    @GetMapping(URLConstant.GET_ALL_LEADS)
    public GetAllResponse getAll(HttpServletResponse response) {
        return leadService.getAll(response);
    }
    @Operation(summary = "Get One Lead By Its Id")
    @GetMapping(URLConstant.GET_ONE_LEAD)
    public BaseResponse getOneLead(@PathVariable UUID leadId, HttpServletResponse response){
        return leadService.getOne(leadId, response);
    }
    @Operation(summary = "Store One Lead's Data")
    @PostMapping(URLConstant.STORE_LEAD)
    public BaseResponse storeLead(@Valid @RequestBody BaseRequest request, HttpServletResponse response){
        return leadService.store(request, response);
    }
    @Operation(summary = "Update One Lead's Data")
    @PutMapping(URLConstant.UPDATE_LEAD)
    public BaseResponse updateOneLead(@PathVariable UUID leadId, @Valid @RequestBody BaseRequest request, HttpServletResponse response){
        return leadService.updateOne(leadId, request, response);
    }
    @Operation(summary = "Delete One Lead By Its Id")
    @DeleteMapping(URLConstant.DELETE_LEAD)
    public BaseResponse deleteOneLead(@PathVariable UUID leadId, HttpServletResponse response){
        return leadService.deleteOne(leadId, response);
    }
}
