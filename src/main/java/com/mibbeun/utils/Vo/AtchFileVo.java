package com.mibbeun.utils.Vo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AtchFileVo {  
	String atchFileId;
	int atchFileSno;
	String atchFilePath;
	String atchFileOgcpNm;
	String atchFileSavNm;
	String atchFileExtsnNm;
	long atchFileSizeNval;
	String fmDate;
	String frstRgsrId;
	String toDate;
	String frstRgstIp;
	String frstRgstDt;
	String lastUpdrId;
	String lastUpdtIp;
	String lastUpdtDt;
}