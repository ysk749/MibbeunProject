package com.mibbeun.utils.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class VoFieldSaveSVo {  
	String msgCode;
	String msgName;
	String idCode;
	String idNm;
	String userYn;
	List<VoFieldSaveVo> voFieldSaveListVo;
}
