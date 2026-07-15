package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.MonthSumVo;
import com.mibbeun.amt.Vo.MonthStrSumVo;

@Mapper
public interface MonthSumMap {  
	List<MonthSumVo>  SelectInMonthSumList(MonthStrSumVo monthStrSumVo);
	List<MonthSumVo>  SelectOutMonthSumList(MonthStrSumVo monthStrSumVo);
	List<MonthSumVo>  SelectInMonthTotSumList(MonthStrSumVo monthStrSumVo);
	List<MonthSumVo>  SelectOutMonthTotSumList(MonthStrSumVo monthStrSumVo);	
}
