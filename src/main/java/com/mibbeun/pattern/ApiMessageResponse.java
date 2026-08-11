package com.mibbeun.pattern;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiMessageResponse {
    private boolean success;
    private String message;
}
