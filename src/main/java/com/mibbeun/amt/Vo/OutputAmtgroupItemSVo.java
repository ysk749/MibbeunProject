package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputAmtgroupItemSVo {  
	String msgCode;
	String msgName;
	OutputAmtgroupItemVo outputAmtgroupItemVo;
	List<OutputAmtgroupItemVo> outputAmtgroupItemListVo;
}