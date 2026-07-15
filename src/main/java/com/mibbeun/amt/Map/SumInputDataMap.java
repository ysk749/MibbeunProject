package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.SumInputDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Mapper
public interface SumInputDataMap {  
		SumInputDataVo  SelectSumInputData(BaseDataVo sumInputDataVo);

		List<SumInputDataVo>  SelectSumInputDataList(BaseDataVo sumInputDataVo);
}
