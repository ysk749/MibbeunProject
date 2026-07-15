package com.mibbeun.login.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class ProgListSVo {  
	String msgCode;
	String msgName;
	ProgListVo progListVo;
	List<ProgListVo> progListListVo;
}
