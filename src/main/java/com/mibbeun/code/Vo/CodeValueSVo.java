package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class CodeValueSVo {  
	String msgCode;
	String msgName;
	CodeValueVo codeValueVo;
	List<CodeValueVo> codeValueListVo;
}
