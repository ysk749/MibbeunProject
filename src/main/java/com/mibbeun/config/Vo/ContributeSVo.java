package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class ContributeSVo {  
	String msgCode;
	String msgName;
	ContributeVo contributeVo;
	List<ContributeVo> contributeListVo;
}
