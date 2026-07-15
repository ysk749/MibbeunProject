package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class PrintDonateSVo {  
	String msgCode;
	String msgName;
	PrintDonateVo printDonateVo;
	List<PrintDonateVo> printDonateListVo;
}
