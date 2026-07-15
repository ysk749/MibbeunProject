package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class MonthSumSVo {  
	String msgCode;
	String msgName;
	MonthSumVo monthSumVo;
	List<MonthSumVo> monthSumListVo;
}
