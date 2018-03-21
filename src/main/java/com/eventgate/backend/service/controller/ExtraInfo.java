package com.eventgate.backend.service.controller;

import lombok.Data;

@Data
public class ExtraInfo {
    private int currentPage;
    private int pageSize;
    private int totalPage;
}
