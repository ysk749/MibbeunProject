package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputAmtgroupItemSelSVo {  
	String msgCode;
	String msgName;
	OutputAmtgroupItemSelVo outputAmtgroupItemSelVo;
	List<OutputAmtgroupItemSelVo> outputAmtgroupItemSelListVo;
}