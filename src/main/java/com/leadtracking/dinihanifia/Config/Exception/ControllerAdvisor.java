package com.leadtracking.dinihanifia.Config.Exception;
import com.leadtracking.dinihanifia.Config.Constant.MessageConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    //400
    @ExceptionHandler(InvalidNamaException.class)
    public ResponseEntity<?> handleBadRequestException(InvalidNamaException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.NAMA_NOT_VALID);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FieldBlankException.class)
    public ResponseEntity<?> handleFieldBlankException(FieldBlankException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.FIELD_IS_NULL);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<?> handleEmailDuplicateException(DuplicateEmailException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.DUPLICATE_EMAIL);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateNoTeleponException.class)
    public ResponseEntity<?> handleNomorTeleponDuplicateException(DuplicateNoTeleponException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.DUPLICATE_NO_TELEPON);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<?> handlerEmailInvalidException(final InvalidEmailException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.EMAIL_NOT_VALID);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidNoTeleponException.class)
    public ResponseEntity<?> handlerNoTeleponInvalidException(final InvalidNoTeleponException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.NO_TELEPON_NOT_VALID);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidNoTeleponLengthException.class)
    public ResponseEntity<?> handlerNoTeleponLengthInvalidException(final InvalidNoTeleponLengthException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.LENGTH_NO_TELEPON_NOT_VALID);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidNamaLengthException.class)
    public ResponseEntity<?> handlerNamaLengthInvalidException(final InvalidNamaLengthException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.BAD_REQUEST.value());
        body.put("responseMessage", MessageConstant.LENGTH_NAMA_NOT_VALID);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    //404
    @ExceptionHandler(LeadIDNotFoundException.class)
    public ResponseEntity<?> handleLeadIdNotFoundException(LeadIDNotFoundException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.NOT_FOUND.value());
        body.put("responseMessage", MessageConstant.LEAD_ID_IS_NOT_FOUND);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleLeadNotFoundException(DataNotFoundException ex){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("responseCode", HttpStatus.NOT_FOUND.value());
        body.put("responseMessage", MessageConstant.LEAD_IS_NOT_FOUND);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
