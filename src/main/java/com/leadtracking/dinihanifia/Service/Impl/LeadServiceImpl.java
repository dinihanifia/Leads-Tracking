package com.leadtracking.dinihanifia.Service.Impl;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;
import com.leadtracking.dinihanifia.Config.Exception.*;
import com.leadtracking.dinihanifia.POJO.Model.Lead;
import com.leadtracking.dinihanifia.POJO.Request.BaseRequest;
import com.leadtracking.dinihanifia.POJO.Response.BaseResponse;
import com.leadtracking.dinihanifia.POJO.Response.GetAllResponse;
import com.leadtracking.dinihanifia.Repository.LeadRepository;
import com.leadtracking.dinihanifia.Service.LeadService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class LeadServiceImpl implements LeadService {

    private final LeadRepository leadRepository;

    @Override
    public GetAllResponse getAll(HttpServletResponse response) {
        var found = leadRepository.findAll();
        if(!found.stream().anyMatch(Objects::nonNull)){
            throw new DataNotFoundException();
        }
        return GetAllResponse.builder()
                .responseCode(HttpStatus.OK.value())
                .responseMessage(MessageConstant.SUCCESS_2)
                .leads(found)
                .build();
    }

    @Override
    public BaseResponse getOne(UUID leadId, HttpServletResponse response) {
        var checkId = leadRepository.findById(leadId);
        if(checkId.isPresent()){
            var getId=checkId.get();
            return BaseResponse.builder()
                    .responseCode(HttpStatus.OK.value())
                    .responseMessage(MessageConstant.SUCCESS_2)
                    .lead(getId)
                    .build();
        } else {
            throw new LeadIDNotFoundException(leadId);
        }
    }

    @Override
    public BaseResponse store(BaseRequest baseRequest, HttpServletResponse httpResponse) {
        var isDuplicateEmail = leadRepository.findByEmail(baseRequest.getEmail());
        if(isDuplicateEmail!=null) {
            throw new DuplicateEmailException(baseRequest.getEmail());
        }
        var isDuplicateNomorTelepon = leadRepository.findByNomorTelepon(baseRequest.getNomorTelepon());
        if (isDuplicateNomorTelepon != null) {
            throw new DuplicateNoTeleponException(baseRequest.getNomorTelepon());
        }
        Lead lead = Lead.builder()
                .nama(baseRequest.getNama())
                .email(baseRequest.getEmail())
                .nomorTelepon(baseRequest.getNomorTelepon())
                .isDeleted(false)
                .build();
        var save = leadRepository.save(lead);
        httpResponse.setStatus(HttpStatus.CREATED.value());
        return BaseResponse.builder()
                .responseCode(HttpStatus.CREATED.value())
                .responseMessage(MessageConstant.SUCCESS)
                .lead(save)
                .build();
    }

    @Override
    public BaseResponse updateOne(UUID leadId, BaseRequest request, HttpServletResponse response) {
        if(leadId==null){
            throw new FieldBlankException();
        }
        var checkId = getOne(leadId, response);
        var isDuplicateEmail = leadRepository.findByEmail(request.getEmail());
        if(isDuplicateEmail!=null) {
            throw new DuplicateEmailException(request.getEmail());
        }
        var isDuplicateNomorTelepon = leadRepository.findByNomorTelepon(request.getNomorTelepon());
        if (isDuplicateNomorTelepon != null) {
            throw new DuplicateNoTeleponException(request.getNomorTelepon());
        }
        var update = checkId.getLead();
        update.setNama(request.getNama());
        update.setEmail(request.getEmail());
        update.setNomorTelepon(request.getNomorTelepon());
        var save = leadRepository.save(update);
        return BaseResponse.builder()
                .responseCode(HttpStatus.OK.value())
                .responseMessage(MessageConstant.SUCCESS)
                .lead(save)
                .build();
    }

    @Override
    public BaseResponse deleteOne(UUID leadId, HttpServletResponse response) {
        if(leadId==null){
            throw new FieldBlankException();
        }
        var checkId = getOne(leadId, response);
        if(checkId.equals(HttpStatus.NOT_FOUND.value())){
            throw new LeadIDNotFoundException(leadId);
        }
        var update = checkId.getLead();
        update.setDeleted(true);
        var save = leadRepository.save(update);
        return BaseResponse.builder()
                .responseCode(HttpStatus.OK.value())
                .responseMessage(MessageConstant.SUCCESS)
                .lead(save)
                .build();
    }
}
