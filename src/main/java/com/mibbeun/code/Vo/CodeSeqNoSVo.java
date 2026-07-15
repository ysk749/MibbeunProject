package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class CodeSeqNoSVo {  
	String msgCode;
	String msgName;
	CodeSeqNoVo codeSeqNoVo;
	List<CodeSeqNoVo> codeSeqNoListVo;
}
