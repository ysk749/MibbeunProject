package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputAmtgroupInfoSVo {  
	String msgCode;
	String msgName;
	OutputAmtgroupInfoVo outputAmtgroupInfoVo;
	List<OutputAmtgroupInfoVo> outputAmtgroupInfoListVo;
}