package com.eventgate.backend.service.dto;

import lombok.Data;

@Data
public class ExtraInfo {
    private int currentPage;
    private int pageSize;
    private int totalPage;
}
