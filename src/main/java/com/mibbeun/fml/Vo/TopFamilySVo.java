package com.mibbeun.fml.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class TopFamilySVo {  
	String msgCode;
	String msgName;
	TopFamilyVo topFamilyVo;
	List<TopFamilyVo> topFamilyListVo;
}
