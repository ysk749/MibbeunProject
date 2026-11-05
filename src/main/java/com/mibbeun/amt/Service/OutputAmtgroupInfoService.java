package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutputAmtgroupInfoMap;
import com.mibbeun.amt.Vo.OutputAmtgroupInfoVo;

@Service
public class OutputAmtgroupInfoService {  
	@Autowired
	OutputAmtgroupInfoMap outputAmtgroupInfoMap;

	// One Select
	public OutputAmtgroupInfoVo outputAmtgroupInfoOneData(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.SelectOutputAmtgroupInfo(outputAmtgroupInfoVo);
	}
	// List Select
	public List<OutputAmtgroupInfoVo> outputAmtgroupInfoListData(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.SelectOutputAmtgroupInfoList(outputAmtgroupInfoVo);
	}
	// insert
	public int insertOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.InsertOutputAmtgroupInfo(outputAmtgroupInfoVo);
	}
	
	public OutputAmtgroupInfoVo insertOutputAmtgroupInfoJson(String jsonData) { 
		return outputAmtgroupInfoMap.InsertOutputAmtgroupInfoJson(jsonData);
	}
		
	// update
	public int updateOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.UpdateOutputAmtgroupInfo(outputAmtgroupInfoVo);
	}
	// delete
	public int deleteOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.DeleteOutputAmtgroupInfo(outputAmtgroupInfoVo);
	}
	// Merge
	public int mergeOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		return outputAmtgroupInfoMap.MergeOutputAmtgroupInfo(outputAmtgroupInfoVo);
	}
}