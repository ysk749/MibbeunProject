package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class FmCodeSVo {  
	String msgCode;
	String msgName;
	FmCodeVo fmCodeVo;
	List<FmCodeVo> fmCodeListVo;
}
