package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputCode3CnteSVo {  
	String msgCode;
	String msgName;
	OutputCode3CnteVo outputCode3CnteVo;
	List<OutputCode3CnteVo> outputCode3CnteListVo;
}
