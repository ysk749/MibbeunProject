package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputCodeListSVo {  
	String msgCode;
	String msgName;
	OutputCodeListVo outputCodeListVo;
	List<OutputCodeListVo> outputCodeListListVo;
}
