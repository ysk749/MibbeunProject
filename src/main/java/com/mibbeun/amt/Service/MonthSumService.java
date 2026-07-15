package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.MonthSumMap;
import com.mibbeun.amt.Vo.MonthSumVo;
import com.mibbeun.amt.Vo.MonthStrSumVo;

@Service
public class MonthSumService {  
	@Autowired
	MonthSumMap monthSumMap;

	// List Select
	public List<MonthSumVo> inMonthSumListData(MonthStrSumVo monthStrSumVo ) { 
		return monthSumMap.SelectInMonthSumList(monthStrSumVo);
	}
	public List<MonthSumVo> outMonthSumListData(MonthStrSumVo monthStrSumVo ) { 
		return monthSumMap.SelectOutMonthSumList(monthStrSumVo);
	}
	public List<MonthSumVo> inMonthTotSumListData(MonthStrSumVo monthStrSumVo ) { 
		return monthSumMap.SelectInMonthTotSumList(monthStrSumVo);
	}
	public List<MonthSumVo> outMonthTotSumListData(MonthStrSumVo monthStrSumVo ) { 
		return monthSumMap.SelectOutMonthTotSumList(monthStrSumVo);
	}	
	
}
