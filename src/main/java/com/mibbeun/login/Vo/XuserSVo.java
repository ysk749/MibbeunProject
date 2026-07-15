package com.mibbeun.login.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class XuserSVo {  
	String msgCode;
	String msgName;
	XuserVo xuserVo;
	List<XuserVo> xuserListVo;
}
