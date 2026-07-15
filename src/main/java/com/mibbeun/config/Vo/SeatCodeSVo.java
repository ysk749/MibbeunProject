package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SeatCodeSVo {  
	String msgCode;
	String msgName;
	SeatCodeVo seatCodeVo;
	List<SeatCodeVo> seatCodeListVo;
}