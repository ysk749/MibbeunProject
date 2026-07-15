package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.InAmtMap;
import com.mibbeun.amt.Map.InSunAmtMap;
import com.mibbeun.amt.Vo.InAmtVo;
import com.mibbeun.amt.Vo.InSunAmtVo;

@Service
public class InAmtService {  
	@Autowired
	InAmtMap inAmtMap;
	@Autowired
	InSunAmtMap inSunAmtMap;

	// One Select
	public InAmtVo inAmtOneData(InAmtVo inAmtVo ) { 
		return inAmtMap.SelectInAmt(inAmtVo);
	}
	// List Select
	public List<InAmtVo> inAmtListData(InAmtVo inAmtVo ) { 
		return inAmtMap.SelectInAmtList(inAmtVo);
	}
	// insert
	public int insertInAmt(InAmtVo inAmtVo ) { 
		return inAmtMap.InsertInAmt(inAmtVo);
	}
	// update
	public int updateInAmt(InAmtVo inAmtVo ) { 
		return inAmtMap.UpdateInAmt(inAmtVo);
	}
	
	// delete
	public int deleteInAmt(InAmtVo inAmtVo ) { 
		return inAmtMap.DeleteInAmt(inAmtVo);
	}	
	
	// insert sun
	public int sunToInAmtInsert(InAmtVo inAmtVo ) {
		InSunAmtVo inSunAmtVo = new InSunAmtVo();
		inSunAmtVo.setDate(inAmtVo.getDate());
		inSunAmtVo = inSunAmtMap.SumInSunAmt(inSunAmtVo);
		
		InAmtVo sunInAmtVo = inAmtMap.SelectInSunAmt(inAmtVo);
		if ((sunInAmtVo != null) && (sunInAmtVo.getCode() != 0)) {
			sunInAmtVo.setAmt(inSunAmtVo.getAmt());
			return inAmtMap.UpdateInAmt(sunInAmtVo);	
		} else {
	  		inAmtVo.setAmt(inSunAmtVo.getAmt());
	  		return inAmtMap.InsertInAmt(inAmtVo);
		}

	}	
	
	// Merge
	public int mergeInAmt(InAmtVo inAmtVo ) { 
		return inAmtMap.MergeInAmt(inAmtVo);
	}
}
