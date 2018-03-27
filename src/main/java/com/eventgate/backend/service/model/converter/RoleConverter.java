package com.eventgate.backend.service.model.converter;

import com.eventgate.backend.service.model.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {

        switch (attribute) {
            case ADMIN:
                return "admin";
            case OPERATOR:
                return "operator";
            case USER:
                return "user";
        }

        throw new AttributeConvertException("Unknown user role type \"" + attribute + "\"");
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "admin":
                return Role.ADMIN;
            case "operator":
                return Role.OPERATOR;
            case "user":
                return Role.USER;
        }
        throw new AttributeConvertException("Unknown user role type \"" + dbData + "\"");
    }
}
