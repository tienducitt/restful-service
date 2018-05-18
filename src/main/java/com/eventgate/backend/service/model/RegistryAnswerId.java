package com.eventgate.backend.service.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class RegistryAnswerId implements Serializable {
    @ManyToOne
    private EventRegistry registry;
    @ManyToOne
    private EventRegistryQuestion question;
}
