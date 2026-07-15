package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.PmRelationMap;
import com.mibbeun.code.Vo.PmRelationVo;

@Service
public class PmRelationService {  
	@Autowired
	PmRelationMap pmRelationMap;

	// One Select
	public PmRelationVo pmRelationOneData(PmRelationVo pmRelationVo ) { 
		return pmRelationMap.SelectPmRelation(pmRelationVo);
	}
	// List Select
	public List<PmRelationVo> pmRelationListData(PmRelationVo pmRelationVo ) { 
		return pmRelationMap.SelectPmRelationList(pmRelationVo);
	}
	// insert
	public int insertPmRelation(PmRelationVo pmRelationVo ) { 
		return pmRelationMap.InsertPmRelation(pmRelationVo);
	}
	// update
	public int updatePmRelation(PmRelationVo pmRelationVo ) { 
		return pmRelationMap.UpdatePmRelation(pmRelationVo);
	}
	// Merge
	public int mergePmRelation(PmRelationVo pmRelationVo ) { 
		return pmRelationMap.MergePmRelation(pmRelationVo);
	}
}
