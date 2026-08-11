package com.mibbeun.pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatternLoginRequest {
    private String userId;
    private String pattern;
}