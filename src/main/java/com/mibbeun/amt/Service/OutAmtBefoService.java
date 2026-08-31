package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OutAmtBefoMap;
import com.mibbeun.amt.Vo.OutAmtBefoVo;

@Service
public class OutAmtBefoService {  
	@Autowired
	OutAmtBefoMap outAmtBefoMap;

	// One Select
	public OutAmtBefoVo outAmtBefoOneData(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.SelectOutAmtBefo(outAmtBefoVo);
	}
	// List Select
	public List<OutAmtBefoVo> outAmtBefoListData(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.SelectOutAmtBefoList(outAmtBefoVo);
	}
	// insert
	public int insertOutAmtBefo(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.InsertOutAmtBefo(outAmtBefoVo);
	}
	
	// insert
	public int insertOutAmtBefo2(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.InsertOutAmtBefo2(outAmtBefoVo);
	}
	// update
	public int updateOutAmtBefo(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.UpdateOutAmtBefo(outAmtBefoVo);
	}
	
	// update
	public int updateOutAmtBefo2(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.UpdateOutAmtBefo2(outAmtBefoVo);
	}	
	
	// update
	public int deleteOutAmtBefo(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.DeleteOutAmtBefo(outAmtBefoVo);
	}
	// update
	public int updateUsrAmtBefo(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.UpdateUsrAmtBefo(outAmtBefoVo);
	}
	
	
	// Merge
	public int mergeOutAmtBefo(OutAmtBefoVo outAmtBefoVo ) { 
		return outAmtBefoMap.MergeOutAmtBefo(outAmtBefoVo);
	}
}
