package com.example.bfhl.dto;

import java.util.List;

public class BfhlRequestDTO {
    private List<String> data;

    public BfhlRequestDTO() {
    }

    public BfhlRequestDTO(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
