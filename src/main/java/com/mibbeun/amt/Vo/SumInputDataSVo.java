package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SumInputDataSVo {  
	String msgCode;
	String msgName;
	SumInputDataVo sumInputDataVo;
	List<SumInputDataVo> sumInputDataListVo;
}
