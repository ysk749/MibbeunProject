package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class InputAmtMSelectSVo {  
	String msgCode;
	String msgName;
	InputAmtMSelectVo inputAmtMSelectVo;
	List<InputAmtMSelectVo> inputAmtMSelectListVo;
}
