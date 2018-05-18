package com.eventgate.backend.service.model.converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class JsonElementConverter implements AttributeConverter<JsonObject, String>{

    private static JsonParser parser = new JsonParser();

    @Override
    public String convertToDatabaseColumn(JsonObject attribute) {
        return attribute.toString();
    }

    @Override
    public JsonObject convertToEntityAttribute(String dbData) {
        return parser.parse(dbData).getAsJsonObject();
    }
}
