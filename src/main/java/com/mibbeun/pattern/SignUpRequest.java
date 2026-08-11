package com.mibbeun.pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String userId;
    private String userNm;
    private String userPswd;
}