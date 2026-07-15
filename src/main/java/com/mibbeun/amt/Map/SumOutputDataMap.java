package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.SumOutputDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@Mapper
public interface SumOutputDataMap {  
		SumOutputDataVo  SelectSumOutputData(BaseDataVo sumOutputDataVo);

		List<SumOutputDataVo>  SelectSumOutputDataList(BaseDataVo sumOutputDataVo);
}
