package com.mibbeun.utils.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class VoSaveSVo {  
	String msgCode;
	String msgName;
	VoSaveVo voSaveVo;
	List<VoSaveVo> voSaveListVo;
}
