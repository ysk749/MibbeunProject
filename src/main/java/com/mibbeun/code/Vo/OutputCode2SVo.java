package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputCode2SVo {  
	String msgCode;
	String msgName;
	OutputCode2Vo outputCode2Vo;
	List<OutputCode2Vo> outputCode2ListVo;
}
