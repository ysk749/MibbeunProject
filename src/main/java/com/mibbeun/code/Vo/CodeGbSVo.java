package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class CodeGbSVo {  
	String msgCode;
	String msgName;
	CodeGbVo codeGbVo;
	List<CodeGbVo> codeGbListVo;
}
