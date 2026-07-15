package com.mibbeun.fml.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.fml.Map.FamilyMap;
import com.mibbeun.fml.Vo.FamilyVo;

@Service
public class FamilyService {  
	@Autowired
	FamilyMap familyMap;

	// One Select
	public FamilyVo familyOneData(FamilyVo familyVo ) { 
		return familyMap.SelectFamily(familyVo);
	}
	// List Select
	public List<FamilyVo> familyListData(FamilyVo familyVo ) { 
		return familyMap.SelectFamilyList(familyVo);
	}
	
	// insert
	public int insertFamily(FamilyVo familyVo ) { 
		return familyMap.InsertFamily(familyVo);
	}
	// update
	public int updateFamily(FamilyVo familyVo ) { 
		return familyMap.UpdateFamily(familyVo);
	}
	// delete
	public int deleteFamily(FamilyVo familyVo ) { 
		return familyMap.DeleteFamily(familyVo);
	}
	// Merge
	public int mergeFamily(FamilyVo familyVo ) { 
		return familyMap.MergeFamily(familyVo);
	}
}
