package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class InSunAmtSVo {  
	String msgCode;
	String msgName;
	InSunAmtVo inSunAmtVo;
	List<InSunAmtVo> inSunAmtListVo;
}
