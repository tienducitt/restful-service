package com.eventgate.backend.service.dto;

import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class JsonInfo {
    private JsonObject body;
    private String tada;
}
