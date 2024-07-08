package br.com.ekan.annotations;

import br.com.ekan.validators.EnumNamePatternValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumNamePatternValidator.class)
public @interface EnumNamePattern {

    String regexp();

    boolean optional() default false;

    String message() default "{javax.validation.constraints.EnumNamePattern.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
