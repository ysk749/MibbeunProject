package com.mibbeun.utils.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class AtchFileSVo {  
	String msgCode;
	String msgName;
	String errormsgid;
	String errormsg;
	List<AtchFileVo> atchFileListVo;
}