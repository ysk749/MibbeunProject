package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.SumAmtDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Mapper
public interface SumAmtDataMap {  
		SumAmtDataVo  SelectSumAmtData(BaseDataVo sumAmtDataVo);

		List<SumAmtDataVo>  SelectSumAmtDataList(BaseDataVo sumAmtDataVo);
}
