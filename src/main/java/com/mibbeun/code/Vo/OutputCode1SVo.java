package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class OutputCode1SVo {  
	String msgCode;
	String msgName;
	OutputCode1Vo outputCode1Vo;
	List<OutputCode1Vo> outputCode1ListVo;
}
