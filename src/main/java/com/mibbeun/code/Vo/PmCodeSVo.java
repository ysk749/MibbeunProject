package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class PmCodeSVo {  
	String msgCode;
	String msgName;
	PmCodeVo pmCodeVo;
	List<PmCodeVo> pmCodeListVo;
}
