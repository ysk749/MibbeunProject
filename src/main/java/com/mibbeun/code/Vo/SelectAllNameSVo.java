package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class SelectAllNameSVo {  
	String msgCode;
	String msgName;
	SelectAllNameVo selectAllNameVo;
	List<SelectAllNameVo> selectAllNameListVo;
}
