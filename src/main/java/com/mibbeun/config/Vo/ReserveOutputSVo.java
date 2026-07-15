package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class ReserveOutputSVo {  
	String msgCode;
	String msgName;
	ReserveOutputVo reserveOutputVo;
	List<ReserveOutputVo> reserveOutputListVo;
}
