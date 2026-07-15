package com.mibbeun.fml.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class FamilySVo {  
	String msgCode;
	String msgName;
	FamilyVo familyVo;
	List<FamilyVo> familyListVo;
}
