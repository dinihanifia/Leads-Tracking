package com.leadtracking.dinihanifia.Service;
import com.leadtracking.dinihanifia.POJO.Request.BaseRequest;
import com.leadtracking.dinihanifia.POJO.Response.BaseResponse;
import com.leadtracking.dinihanifia.POJO.Response.GetAllResponse;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

public interface LeadService {
    GetAllResponse getAll(HttpServletResponse response);
    BaseResponse getOne(UUID leadId, HttpServletResponse response);
    BaseResponse store(BaseRequest baseRequest, HttpServletResponse response);
    BaseResponse updateOne(UUID leadId, BaseRequest request, HttpServletResponse response);
    BaseResponse deleteOne(UUID leadId, HttpServletResponse response);
}
