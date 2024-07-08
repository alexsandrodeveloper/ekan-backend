package br.com.ekan.validators;

import br.com.ekan.annotations.EnumNamePattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EnumNamePatternValidator implements ConstraintValidator<EnumNamePattern, Enum<?>> {

    private Pattern pattern;
    private boolean optional;

    @Override
    public void initialize(EnumNamePattern annotation) {
        pattern = Pattern.compile(annotation.regexp());
        optional = annotation.optional();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return optional;
        }
        return pattern.matcher(value.name()).matches();
    }
}
