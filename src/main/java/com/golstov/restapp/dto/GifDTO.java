package com.golstov.restapp.dto;

import java.util.Map;

public class GifDTO {
    Map<String, Object> data;

    public GifDTO() {
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GifDTO{" +
                "data=" + data +
                '}';
    }
}
