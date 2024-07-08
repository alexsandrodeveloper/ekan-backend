package br.com.ekan.validators;

import br.com.ekan.annotations.Document;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class DocumentValidator implements ConstraintValidator<Document, String> {

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{11}");
    private static final Pattern CNPJ_PATTERN = Pattern.compile("\\d{14}");
    private static final Pattern RG_PATTERN = Pattern.compile("\\d{9}");

    @Override
    public void initialize(Document constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return isValidCPF(value) || isValidCNPJ(value) || isValidRG(value);
    }

    private boolean isValidCPF(String cpf) {
        if (!CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }
        return true;
    }

    private boolean isValidCNPJ(String cnpj) {
        if (!CNPJ_PATTERN.matcher(cnpj).matches()) {
            return false;
        }
        return true;
    }

    private boolean isValidRG(String rg) {
        if (!RG_PATTERN.matcher(rg).matches()) {
            return false;
        }
        return true;
    }
}

