package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SumDataSVo {  
	String msgCode;
	String msgName;
	SumDataVo sumDataVo;
	List<SumDataVo> sumDataListVo;
}
