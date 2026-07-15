package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.SumInputDataMap;
import com.mibbeun.amt.Vo.SumInputDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Service
public class SumInputDataService {  
	@Autowired
	SumInputDataMap sumInputDataMap;

	// One Select
	public SumInputDataVo sumInputDataOneData(BaseDataVo sumInputDataVo ) { 
		return sumInputDataMap.SelectSumInputData(sumInputDataVo);
	}
	// List Select
	public List<SumInputDataVo> sumInputDataListData(BaseDataVo sumInputDataVo ) { 
		return sumInputDataMap.SelectSumInputDataList(sumInputDataVo);
	}
}
