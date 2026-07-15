package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class InAmtSVo {  
	String msgCode;
	String msgName;
	InAmtVo inAmtVo;
	List<InAmtVo> inAmtListVo;
}
