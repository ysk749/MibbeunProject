package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutAmtSVo {  
	String msgCode;
	String msgName;
	OutAmtVo outAmtVo;
	List<OutAmtVo> outAmtListVo;
}
