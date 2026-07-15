package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SumOutputDataSVo {  
	String msgCode;
	String msgName;
	SumOutputDataVo sumOutputDataVo;
	List<SumOutputDataVo> sumOutputDataListVo;
}
