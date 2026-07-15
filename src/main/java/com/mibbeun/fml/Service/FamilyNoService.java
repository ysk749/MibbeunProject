package com.mibbeun.fml.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mibbeun.fml.Map.FamilyNoMap;
import com.mibbeun.fml.Vo.FamilyNoVo;
import com.mibbeun.fml.Vo.FamilyVo;

@Service
public class FamilyNoService {  
	@Autowired
	FamilyNoMap familyNoMap;

	// One Select
	public FamilyNoVo familyNoOneData(FamilyNoVo familyNoVo ) { 
		return familyNoMap.SelectFamilyNo(familyNoVo);
	}
	// List Select
	public List<FamilyNoVo> familyNoListData(FamilyNoVo familyNoVo ) { 
		return familyNoMap.SelectFamilyNoList(familyNoVo);
	}
	public List<FamilyNoVo> familyGroupListData(FamilyNoVo familyNoVo ) { 
		return familyNoMap.SelectFamilyGroupList(familyNoVo);
	}
	
	
	public FamilyNoVo familyNoOneName(FamilyNoVo familyNoVo ) { 
		return familyNoMap.SelectFamilyNoName(familyNoVo);
	}	
	
	public FamilyNoVo maxSeqNoFamily(FamilyNoVo familyNoVo ) { 
		return familyNoMap.MaxSeqNoFamily(familyNoVo);
	}		
}
