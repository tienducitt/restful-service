package com.eventgate.backend.service.model.converter;

import com.eventgate.backend.service.model.MemberRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MemberRoleConverter implements AttributeConverter<MemberRole, String> {

    @Override
    public String convertToDatabaseColumn(MemberRole attribute) {
        switch (attribute) {
            case ADMIN:
                return "admin";
            case CHECK_IN:
                return "check_in";
        }
        throw new AttributeConvertException("Unknown team member role type \"" + attribute + "\"");
    }

    @Override
    public MemberRole convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "admin":
                return MemberRole.ADMIN;
            case "check_in":
                return MemberRole.CHECK_IN;
        }
        throw new AttributeConvertException("Unknown user role type \"" + dbData + "\"");
    }
}
