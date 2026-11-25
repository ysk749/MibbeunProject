package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.config.Map.ContributeMap;
import com.mibbeun.config.Vo.ContributeVo;

@Service
public class ContributeService {  
	@Autowired
	ContributeMap contributeMap;

	// One Select
	public ContributeVo contributeOneData(ContributeVo contributeVo ) { 
		return contributeMap.SelectContribute(contributeVo);
	}
	// List Select
	public List<ContributeVo> contributeListData(ContributeVo contributeVo ) { 
		return contributeMap.SelectContributeList(contributeVo);
	}
	// insert
	public int insertContribute(ContributeVo contributeVo ) { 
		return contributeMap.InsertContribute(contributeVo);
	}
	// update
	public int updateContribute(ContributeVo contributeVo ) { 
		return contributeMap.UpdateContribute(contributeVo);
	}
	// delete
	public int deleteContribute(ContributeVo contributeVo ) { 
		return contributeMap.DeleteContribute(contributeVo);
	}
	
	//  이전 기부금을 참조하여 새로 생성
	public int newYearMakeContribute(ContributeVo contributeVo ) { 
		return contributeMap.NewYearMakeContribute(contributeVo);
	}	
	
	// Merge
	public int mergeContribute(ContributeVo contributeVo ) { 
		return contributeMap.MergeContribute(contributeVo);
	}
}
