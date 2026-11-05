package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutputAmtgroupItemMap;
import com.mibbeun.amt.Vo.OutputAmtgroupItemVo;

@Service
public class OutputAmtgroupItemService {  
	@Autowired
	OutputAmtgroupItemMap outputAmtgroupItemMap;

	// One Select
	public OutputAmtgroupItemVo outputAmtgroupItemOneData(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.SelectOutputAmtgroupItem(outputAmtgroupItemVo);
	}
	// List Select
	public List<OutputAmtgroupItemVo> outputAmtgroupItemListData(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.SelectOutputAmtgroupItemList(outputAmtgroupItemVo);
	}
	// insert
	public int insertOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.InsertOutputAmtgroupItem(outputAmtgroupItemVo);
	}
	// JSON Insert
	public OutputAmtgroupItemVo insertOutputAmtgroupItemJson(String jsonData ) { 
		return outputAmtgroupItemMap.InsertOutputAmtgroupItemJson(jsonData);
	}
		
	// update
	public int updateOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.UpdateOutputAmtgroupItem(outputAmtgroupItemVo);
	}
	// delete
	public int deleteOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.DeleteOutputAmtgroupItem(outputAmtgroupItemVo);
	}
	// Merge
	public int mergeOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		return outputAmtgroupItemMap.MergeOutputAmtgroupItem(outputAmtgroupItemVo);
	}
}