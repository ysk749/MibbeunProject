package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class InputFamilyItemSVo {  
	String msgCode;
	String msgName;
	InputFamilyItemVo inputFamilyItemVo;
	List<InputFamilyItemVo> inputFamilyItemListVo;
}
