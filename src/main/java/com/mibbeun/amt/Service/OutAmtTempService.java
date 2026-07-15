package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutAmtTempMap;
import com.mibbeun.amt.Vo.OutAmtTempVo;

@Service
public class OutAmtTempService {  
	@Autowired
	OutAmtTempMap outAmtTempMap;

	// One Select
	public OutAmtTempVo outAmtTempOneData(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.SelectOutAmtTemp(outAmtTempVo);
	}
	// List Select
	public List<OutAmtTempVo> outAmtTempListData(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.SelectOutAmtTempList(outAmtTempVo);
	}
	// insert
	public int insertOutAmtTemp(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.InsertOutAmtTemp(outAmtTempVo);
	}
	// update
	public int updateOutAmtTemp(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.UpdateOutAmtTemp(outAmtTempVo);
	}
	
	// update
	public int deleteOutAmtTemp(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.DeleteOutAmtTemp(outAmtTempVo);
	}
	// update
	public int updateUsrAmtTemp(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.UpdateUsrAmtTemp(outAmtTempVo);
	}
	
	
	// Merge
	public int mergeOutAmtTemp(OutAmtTempVo outAmtTempVo ) { 
		return outAmtTempMap.MergeOutAmtTemp(outAmtTempVo);
	}
}
