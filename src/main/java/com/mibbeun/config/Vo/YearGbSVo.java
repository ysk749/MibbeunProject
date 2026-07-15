package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class YearGbSVo {  
	String msgCode;
	String msgName;
	YearGbVo yearGbVo;
	List<YearGbVo> yearGbListVo;
}
