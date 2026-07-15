package com.mibbeun.code.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class PmRelationSVo {  
	String msgCode;
	String msgName;
	PmRelationVo pmRelationVo;
	List<PmRelationVo> pmRelationListVo;
}
