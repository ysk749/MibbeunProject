package com.mibbeun.amt.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class InputFamilySumSVo {  
	String msgCode;
	String msgName;
	InputFamilySumVo inputFamilySumVo;
	List<InputFamilySumVo> inputFamilySumListVo;
}
