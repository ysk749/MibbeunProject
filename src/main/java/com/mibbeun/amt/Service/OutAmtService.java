package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutAmtMap;
import com.mibbeun.amt.Vo.OutAmtVo;

@Service
public class OutAmtService {  
	@Autowired
	OutAmtMap outAmtMap;

	// One Select
	public int deleteOutOtherDataAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.DeleteOutOtherDataAmt(outAmtVo);
	}

	public int insertOutOtherDataAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.InsertOutOtherDataAmt(outAmtVo);
	}
		
	// One Select
	public OutAmtVo outAmtOneData(OutAmtVo outAmtVo ) { 
		return outAmtMap.SelectOutAmt(outAmtVo);
	}
	// List Select
	public List<OutAmtVo> outAmtListData(OutAmtVo outAmtVo ) { 
		return outAmtMap.SelectOutAmtList(outAmtVo);
	}
	// insert
	public int insertOutAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.InsertOutAmt(outAmtVo);
	}
	// update
	public int updateOutAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.UpdateOutAmt(outAmtVo);
	}

	// delete
	public int deleteOutAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.DeleteOutAmt(outAmtVo);
	}
	
	// Merge
	public int mergeOutAmt(OutAmtVo outAmtVo ) { 
		return outAmtMap.MergeOutAmt(outAmtVo);
	}
}
