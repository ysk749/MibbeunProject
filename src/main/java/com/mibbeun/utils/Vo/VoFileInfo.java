package com.mibbeun.utils.Vo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VoFileInfo {  
	String inoutType;
	String fieldPath;
	String fieldName;
	String errorMsg;
	int fieldSize;
	int fieldScale;
	String fieldReference;
	String fieldUseYn;
}