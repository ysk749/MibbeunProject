package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutAmtTempSVo {  
	String msgCode;
	String msgName;
	OutAmtTempVo outAmtTempVo;
	List<OutAmtTempVo> outAmtTempListVo;
}
