package com.mibbeun.pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponse {
    private String userId;
    private String userNm;
    private String accessToken;
}