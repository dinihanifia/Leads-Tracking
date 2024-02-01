package com.leadtracking.dinihanifia.Annotations;
import com.leadtracking.dinihanifia.Config.Exception.FieldBlankException;
import com.leadtracking.dinihanifia.Config.Exception.InvalidEmailException;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidation.EmailValidator.class)
public @interface EmailValidation {
    public String message() default "Invalid email";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};

    public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
        @Override
        public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
            if(email.isBlank()){
                throw new FieldBlankException();
            }
            String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            } else {
                throw new InvalidEmailException();
            }
        }
    }
}
