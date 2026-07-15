package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.SumAmtDataMap;
import com.mibbeun.amt.Vo.SumAmtDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Service
public class SumAmtDataService {  
	@Autowired
	SumAmtDataMap sumAmtDataMap;

	// One Select
	public SumAmtDataVo sumAmtDataOneData(BaseDataVo sumAmtDataVo ) { 
		return sumAmtDataMap.SelectSumAmtData(sumAmtDataVo);
	}
	// List Select
	public List<SumAmtDataVo> sumAmtDataListData(BaseDataVo sumAmtDataVo ) { 
		return sumAmtDataMap.SelectSumAmtDataList(sumAmtDataVo);
	}
}
