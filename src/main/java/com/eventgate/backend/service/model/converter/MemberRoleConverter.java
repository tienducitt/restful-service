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
            case CHECKIN:
                return "checkin";
        }
        throw new AttributeConvertException("Unknown team member role type \"" + attribute + "\"");
    }

    @Override
    public MemberRole convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "admin":
                return MemberRole.ADMIN;
            case "checkin":
                return MemberRole.CHECKIN;
        }
        throw new AttributeConvertException("Unknown user role type \"" + dbData + "\"");
    }
}
