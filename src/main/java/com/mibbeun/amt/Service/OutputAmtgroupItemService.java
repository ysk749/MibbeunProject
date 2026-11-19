package com.mibbeun.amt.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutputAmtgroupItemMap;
import com.mibbeun.amt.Vo.OutputAmtgroupItemVo;
import com.mibbeun.amt.Vo.OutputAmtgroupItemSelVo;


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
	
	// List Select
	public List<OutputAmtgroupItemSelVo> outputAmtgroupItemSelListData(OutputAmtgroupItemSelVo outputAmtgroupItemSelVo ) { 
		//return outputAmtgroupItemMap.SelectOutputAmtgroupItemSelList(outputAmtgroupItemSelVo);
		
		List<OutputAmtgroupItemSelVo> list =
			    Optional.ofNullable(outputAmtgroupItemMap.SelectOutputAmtgroupItemSelList(outputAmtgroupItemSelVo))
			            .orElseGet(Collections::emptyList);		
		return list;
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