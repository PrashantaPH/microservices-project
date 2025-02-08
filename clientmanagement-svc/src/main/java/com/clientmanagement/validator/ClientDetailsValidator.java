package com.clientmanagement.validator;

import com.clientmanagement.annotations.ValidClient;
import com.clientmanagement.model.ClientDetails;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

import static com.clientmanagement.util.ClientsConstants.*;

public class ClientDetailsValidator implements ConstraintValidator<ValidClient, ClientDetails> {

    private String operation;

    @Override
    public void initialize(ValidClient constraintAnnotation) {
        operation = constraintAnnotation.operation();
    }

    @Override
    public boolean isValid(ClientDetails clientDetails, ConstraintValidatorContext constraintValidatorContext) {

        if (operation.equals(CREATE)) {
            List<String> fieldList = Arrays.asList(
                    clientDetails.getEntityName(),
                    clientDetails.getEmailId(),
                    clientDetails.getAddress(),
                    clientDetails.getCity(),
                    clientDetails.getPostalCode(),
                    clientDetails.getCountryCode(),
                    clientDetails.getCountryName(),
                    clientDetails.getClientType()
            );

            boolean areFieldsValid = fieldList.stream().allMatch(this::isFieldValid);
            if (!areFieldsValid) {
                customMessageForValidation(constraintValidatorContext, MISSING_PARAMETER, "One or more required fields are empty");
                return false;
            }
        }

        return true;
    }

    private boolean isFieldValid(String field) {
        return field != null && !field.trim().isEmpty();
    }

    private void customMessageForValidation(ConstraintValidatorContext constraintContext, String errorCode, String message) {
        constraintContext.disableDefaultConstraintViolation();
        constraintContext.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(errorCode)
                .addConstraintViolation();
    }
}
