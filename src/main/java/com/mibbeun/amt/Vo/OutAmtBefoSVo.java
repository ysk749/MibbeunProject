package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutAmtBefoSVo {  
	String msgCode;
	String msgName;
	OutAmtBefoVo outAmtBefoVo;
	List<OutAmtBefoVo> outAmtBefoListVo;
}
