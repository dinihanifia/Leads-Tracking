package com.leadtracking.dinihanifia.Annotations;
import com.leadtracking.dinihanifia.Config.Exception.FieldBlankException;
import com.leadtracking.dinihanifia.Config.Exception.InvalidNoTeleponException;
import com.leadtracking.dinihanifia.Config.Exception.InvalidNoTeleponLengthException;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NomorTeleponValidation.NomorTeleponValidator.class)
public @interface NomorTeleponValidation {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    public class NomorTeleponValidator implements ConstraintValidator<NomorTeleponValidation, String> {

        @Override
        public boolean isValid(String nomorTelepon, ConstraintValidatorContext constraintValidatorContext) {
            if(nomorTelepon == null){
                throw new FieldBlankException();
            }
            if(!nomorTelepon.matches("[0-9]+")){
                throw new InvalidNoTeleponException();
            }
            if(nomorTelepon.length() < 11 || nomorTelepon.length() > 13){
                throw new InvalidNoTeleponLengthException();
            }
            return true;
        }
    }
}
