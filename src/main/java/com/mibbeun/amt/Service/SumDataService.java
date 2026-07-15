package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.SumDataMap;
import com.mibbeun.amt.Vo.SumDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Service
public class SumDataService {  
	@Autowired
	SumDataMap sumDataMap;

	// One Select
	public SumDataVo sumDataOneData(BaseDataVo sumDataVo ) { 
		return sumDataMap.SelectSumData(sumDataVo);
	}
	// List Select
	public List<SumDataVo> sumDataListData(BaseDataVo sumDataVo ) { 
		return sumDataMap.SelectSumDataList(sumDataVo);
	}
}
