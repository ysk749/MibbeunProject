package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SumAmtDataSVo {  
	String msgCode;
	String msgName;
	SumAmtDataVo sumAmtDataVo;
	List<SumAmtDataVo> sumAmtDataListVo;
}
