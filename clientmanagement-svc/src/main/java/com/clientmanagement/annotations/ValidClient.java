package com.clientmanagement.annotations;

import com.clientmanagement.validator.ClientDetailsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Constraint(validatedBy = ClientDetailsValidator.class)
public @interface ValidClient {

    String operation();

    String message() default  "Invalid client data request.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
