package com.mibbeun.fml.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.fml.Map.TopFamilyMap;
import com.mibbeun.fml.Vo.TopFamilyVo;

@Service
public class TopFamilyService {  
	@Autowired
	TopFamilyMap topFamilyMap;

	// One Select
	public TopFamilyVo topFamilyOneData(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.SelectTopFamily(topFamilyVo);
	}
	// List Select
	public List<TopFamilyVo> topFamilyListData(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.SelectTopFamilyList(topFamilyVo);
	}
	// insert
	public int insertTopFamily(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.InsertTopFamily(topFamilyVo);
	}
	// update
	public int updateTopFamily(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.UpdateTopFamily(topFamilyVo);
	}
	// delete
	public int deleteTopFamily(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.DeleteTopFamily(topFamilyVo);
	}
	// Merge
	public int mergeTopFamily(TopFamilyVo topFamilyVo ) { 
		return topFamilyMap.MergeTopFamily(topFamilyVo);
	}
}
