package com.mibbeun.fml.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class FamilyNoSVo {  
	String msgCode;
	String msgName;
	FamilyNoVo familyNoVo;
	List<FamilyNoVo> familyNoListVo;
}
