package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.SumOutputDataMap;
import com.mibbeun.amt.Vo.SumOutputDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Service
public class SumOutputDataService {  
	@Autowired
	SumOutputDataMap sumOutputDataMap;

	// One Select
	public SumOutputDataVo sumOutputDataOneData(BaseDataVo sumOutputDataVo ) { 
		return sumOutputDataMap.SelectSumOutputData(sumOutputDataVo);
	}
	// List Select
	public List<SumOutputDataVo> sumOutputDataListData(BaseDataVo sumOutputDataVo ) { 
		return sumOutputDataMap.SelectSumOutputDataList(sumOutputDataVo);
	}
}
