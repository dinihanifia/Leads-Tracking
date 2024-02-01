package com.leadtracking.dinihanifia;
import com.leadtracking.dinihanifia.Config.Exception.DataNotFoundException;
import com.leadtracking.dinihanifia.Config.Exception.FieldBlankException;
import com.leadtracking.dinihanifia.Config.Exception.LeadIDNotFoundException;
import com.leadtracking.dinihanifia.POJO.Model.Lead;
import com.leadtracking.dinihanifia.POJO.Request.BaseRequest;
import com.leadtracking.dinihanifia.Repository.LeadRepository;
import com.leadtracking.dinihanifia.Service.Impl.LeadServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ExtendWith({MockitoExtension.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JunitTestsCase {

    @InjectMocks
    private LeadServiceImpl leadService;
    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    LeadRepository leadRepository;
    List<Lead> leadList;

    @BeforeEach
    void initUseCase() throws ParseException {
        String dateString = "2024-02-01 12:30:45";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        Lead lead1 = new Lead(UUID.fromString("8aadde7a-9280-4117-9781-1d9587b5a117"), "dini", "dini@gmail.com", "085890700410", false, timestamp, null);
        Lead lead2 = new Lead(UUID.fromString("2c8fd860-5c0a-4ba5-b047-346c19912f18"), "billie", "billie@gmail.com", "08118822334", false, timestamp, null);
        Lead lead3 = new Lead(UUID.fromString("ff4dac23-6b71-42ab-b5cb-8957b377dfbb"), "dinidini", "dinihaanifiaa@gmail.com", "0858907085890", false, timestamp, null);
        Lead lead4 = new Lead(UUID.fromString("8c9e24e6-340e-42f3-bb96-bdcf06ce6a72"), "dinih", "1dini.@gmail.com", "085890700455", true, timestamp, null);
        List<Lead> leads = Arrays.asList(lead1, lead2, lead3, lead4);
        leadList=leadRepository.saveAll(leads);

    }

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("JUnit Tests for register lead's data")
    public void addValidLeadData_WhenSave_thenReturnStoreLead(){
        BaseRequest baseRequest = BaseRequest.builder()
                .nama("billie")
                .email("billiey@gmail.com")
                .nomorTelepon("087777123456")
                .build();
        var save = leadService.store(baseRequest, httpServletResponse);
        Assertions.assertEquals(201, save.getResponseCode());
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    @DisplayName("JUnit Tests inputting invalid nama when register")
    public void InputInvalidNama_thenReturnFalse(){
        BaseRequest baseRequest = BaseRequest.builder()
                .nama("b")
                .email("billiegmail.com")
                .nomorTelepon("087777123456")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
        BaseRequest baseRequest2 = BaseRequest.builder()
                .nama("")
                .email("billiey@gmail.com")
                .nomorTelepon("087777123456")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
        BaseRequest baseRequest3 = BaseRequest.builder()
                .nama("billie orang paling ganteng sedunia, billie orang paling ganteng")
                .email("billiey@gmail.com")
                .nomorTelepon("087777123456")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    @DisplayName("JUnit Tests inputting invalid email when register")
    public void InputInvalidEmail_thenReturnFalse(){
        BaseRequest baseRequest = BaseRequest.builder()
                .nama("bill")
                .email("billiegmail.com")
                .nomorTelepon("087777123456")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
        BaseRequest baseRequest2 = BaseRequest.builder()
                .nama("bill")
                .email("")
                .nomorTelepon("087777123456")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    @DisplayName("JUnit Tests inputting invalid nomor telepon when register")
    public void InputInvalidNoTelepon_thenReturnFalse(){
        BaseRequest baseRequest = BaseRequest.builder()
                .nama("bill")
                .email("billiey@gmail.com")
                .nomorTelepon("0888")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
        BaseRequest baseRequest2 = BaseRequest.builder()
                .nama("bill")
                .email("billiey@gmail.com")
                .nomorTelepon("")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
        BaseRequest baseRequest3 = BaseRequest.builder()
                .nama("bill")
                .email("billiey@gmail.com")
                .nomorTelepon("08880888088808")
                .build();
        org.assertj.core.api.Assertions.assertThat(false);
    }

    // update lead's data inputting correctly

    // update lead's data with invalid lead id
    @Test
    @Order(5)
    @Rollback(value = false)
    @DisplayName("JUnit Tests inputting invalid lead id when updating lead's data")
    public void InputInvalidLeadIdWhenUpdate_thenReturnFalse() {

        // lead ID is not found
        UUID leadId = UUID.fromString("ff4dac23-6b71-42ab-b5cb-8957b377dfbc");
        BaseRequest baseRequest = BaseRequest.builder()
                .nama("dinidini")
                .email("dinidinii@gmail.com")
                .nomorTelepon("085890700321")
                .build();
        assertThrows(LeadIDNotFoundException.class, () -> {
            leadService.updateOne(leadId, baseRequest, httpServletResponse);
        });

        // empty lead ID
        UUID leadId2 = null;
        BaseRequest baseRequest2 = BaseRequest.builder()
                .nama("dinidini")
                .email("dinidinii@gmail.com")
                .nomorTelepon("085890700321")
                .build();
        assertThrows(FieldBlankException.class, () -> {
            leadService.updateOne(leadId2, baseRequest2, httpServletResponse);
        });
    }

    // update lead's data inputting invalid nama
    // update lead's data inputting invalid email
    // update lead's data inputting invalid nomorTelepon

    // get one lead with valid lead id
    @Test
    @Order(6)
    @Rollback(value = false)
    @DisplayName("JUnit Tests get one lead by valid lead id")
    public void getOneLead_thenReturnTrue() {
        // lead ID is found
        UUID leadId = UUID.fromString("2c8fd860-5c0a-4ba5-b047-346c19912f18");
        var response = leadService.getOne(leadId, httpServletResponse);
        Assertions.assertEquals(200, response.getResponseCode());
    }

    // lead ID is not found
    @Test
    @Order(7)
    @Rollback(value = false)
    @DisplayName("JUnit Tests get one lead and expected not found")
    public void getOneLead_thenReturnFalse() {
        // lead ID is found
        UUID leadId = UUID.fromString("2c8fd890-5c0a-4ba5-b047-346c19912f18");
        assertThrows(LeadIDNotFoundException.class, () -> {
            leadService.getOne(leadId,httpServletResponse);
        });
    }

    // get all lead
    @Test
    @Order(8)
    @Rollback(value = false)
    @DisplayName("JUnit Tests for get all leads")
    void getAll(){
        var response = leadService.getAll(httpServletResponse);
        org.assertj.core.api.Assertions.assertThat(response.getLeads().size()).isGreaterThan(0);
        assertThrows(DataNotFoundException.class, () -> {
            leadService.getAll(httpServletResponse);
        });
    }

    // delete lead with invalid lead id
    @Test
    @Order(9)
    @Rollback(value = false)
    @DisplayName("JUnit Tests for delete lead inputting invalid lead id")
    void deleteLeadDataInputInvalidLead_ReturnFalse(){
        UUID leadId = UUID.fromString("2c8fd890-5c0a-4ba5-b047-346c19912f19");
        UUID leadId2 = null;
        assertThrows(LeadIDNotFoundException.class, () -> {
            leadService.deleteOne(leadId, httpServletResponse);
        });
        assertThrows(FieldBlankException.class, () -> {
            leadService.deleteOne(leadId2, httpServletResponse);
        });
    }

    // delete lead with valid lead id
    @Test
    @Order(10)
    @Rollback(value = false)
    @DisplayName("JUnit Tests for delete lead")
    void deleteLeadData_ReturnTrue(){
        UUID leadId = UUID.fromString("ff4dac23-6b71-42ab-b5cb-8957b377dfbb");
        leadService.deleteOne(leadId, httpServletResponse);
        Assertions.assertTrue(true);
    }
}