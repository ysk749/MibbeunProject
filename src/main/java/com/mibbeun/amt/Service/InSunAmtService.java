package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.InSunAmtMap;
import com.mibbeun.amt.Vo.InSunAmtVo;

@Service
public class InSunAmtService {  
	@Autowired
	InSunAmtMap inSunAmtMap;

	// One Select
	public InSunAmtVo inSunAmtOneData(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.SelectInSunAmt(inSunAmtVo);
	}
	// One Select
	public InSunAmtVo sumInSunAmt(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.SumInSunAmt(inSunAmtVo);
	}
	
	
	// List Select
	public List<InSunAmtVo> inSunAmtListData(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.SelectInSunAmtList(inSunAmtVo);
	}
	// insert
	public int insertInSunAmt(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.InsertInSunAmt(inSunAmtVo);
	}
	// update
	public int updateInSunAmt(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.UpdateInSunAmt(inSunAmtVo);
	}
	
	// update
	public int deleteInSunAmt(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.DeleteInSunAmt(inSunAmtVo);
	}	
	// Merge
	public int mergeInSunAmt(InSunAmtVo inSunAmtVo ) { 
		return inSunAmtMap.MergeInSunAmt(inSunAmtVo);
	}
}
