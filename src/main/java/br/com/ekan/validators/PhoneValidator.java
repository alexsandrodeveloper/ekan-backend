package br.com.ekan.validators;

import br.com.ekan.annotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    // Padrão para telefone residencial (por exemplo, 1123456789)
    private static final Pattern RESIDENCIAL_PATTERN = Pattern.compile("\\d{10}");

    // Padrão para telefone celular (por exemplo, 11987654321)
    private static final Pattern CELULAR_PATTERN = Pattern.compile("\\d{11}");

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return isValidResidential(value) || isValidCellular(value);
    }

    private boolean isValidResidential(String phone) {
        return RESIDENCIAL_PATTERN.matcher(phone).matches();
    }

    private boolean isValidCellular(String phone) {
        return CELULAR_PATTERN.matcher(phone).matches();
    }
}


