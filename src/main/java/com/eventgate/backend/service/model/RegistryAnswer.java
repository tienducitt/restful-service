package com.eventgate.backend.service.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity(name = "registry_answers")
public class RegistryAnswer {

    @EmbeddedId
    private RegistryAnswerId pk;

    private String answer;
}
