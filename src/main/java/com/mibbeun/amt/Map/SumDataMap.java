package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.SumDataVo;
import com.mibbeun.amt.Vo.InSumDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;


@Mapper
public interface SumDataMap {  
		SumDataVo  SelectSumData(BaseDataVo sumDataVo);

		List<SumDataVo>  SelectSumDataList(BaseDataVo sumDataVo);
}
