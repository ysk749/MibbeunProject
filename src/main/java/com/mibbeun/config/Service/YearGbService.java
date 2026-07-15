package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.config.Map.YearGbMap;
import com.mibbeun.config.Vo.YearGbVo;

@Service
public class YearGbService {  
	@Autowired
	YearGbMap yearGbMap;

	// One Select
	public YearGbVo yearGbOneData(YearGbVo yearGbVo ) { 
		return yearGbMap.SelectYearGb(yearGbVo);
	}
	// List Select
	public List<YearGbVo> yearGbListData(YearGbVo yearGbVo ) { 
		return yearGbMap.SelectYearGbList(yearGbVo);
	}
	// insert
	public int insertYearGb(YearGbVo yearGbVo ) { 
		return yearGbMap.InsertYearGb(yearGbVo);
	}
	// update
	public int updateYearGb(YearGbVo yearGbVo ) { 
		return yearGbMap.UpdateYearGb(yearGbVo);
	}
	// Merge
	public int mergeYearGb(YearGbVo yearGbVo ) { 
		return yearGbMap.MergeYearGb(yearGbVo);
	}
}
