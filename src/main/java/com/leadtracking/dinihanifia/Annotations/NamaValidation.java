package com.leadtracking.dinihanifia.Annotations;
import com.leadtracking.dinihanifia.Config.Exception.InvalidNamaException;
import com.leadtracking.dinihanifia.Config.Exception.FieldBlankException;
import com.leadtracking.dinihanifia.Config.Exception.InvalidNamaLengthException;
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
@Constraint(validatedBy = NamaValidation.SizeValidator.class)
public @interface NamaValidation {
    public String message() default "Invalid Nama";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    public class SizeValidator implements ConstraintValidator<NamaValidation, String> {

        private int min, max;

        @Override
        public void initialize(NamaValidation annotation) {
            min = annotation.min();
            max = annotation.max();
        }

        @Override
        public boolean isValid(String nama, ConstraintValidatorContext constraintValidatorContext) {
            String regex = "^[a-zA-Z\\s]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(nama);
            if(nama.isBlank()){
                throw new FieldBlankException();
            } else if (!(nama.length() >=min && nama.length()<=max)) {
                throw new InvalidNamaLengthException();
            } else if(!matcher.matches()){
                throw new InvalidNamaException();
            }
            return true;
        }
    }
}
