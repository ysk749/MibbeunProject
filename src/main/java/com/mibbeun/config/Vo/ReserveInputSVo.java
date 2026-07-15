package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class ReserveInputSVo {  
	String msgCode;
	String msgName;
	ReserveInputVo reserveInputVo;
	List<ReserveInputVo> reserveInputListVo;
}
