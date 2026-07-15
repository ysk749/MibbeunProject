package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class CarryOverSVo {  
	String msgCode;
	String msgName;
	CarryOverVo carryOverVo;
	List<CarryOverVo> carryOverListVo;
}
