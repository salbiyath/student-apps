package com.salbiyath.getstudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceResponse {

    private String status;

    private String message;

    private String statusCode;

    private Object data;

}
