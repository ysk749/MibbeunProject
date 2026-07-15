package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mibbeun.config.Vo.ReserveInputVo;

@Mapper
public interface ReserveInputMap {  
		ReserveInputVo  SelectReserveInput(ReserveInputVo reserveInputVo);

		List<ReserveInputVo>  SelectReserveInputList(ReserveInputVo reserveInputVo);

		int InsertReserveInput(ReserveInputVo reserveInputVo);

		int UpdateReserveInput(ReserveInputVo reserveInputVo);
		int DeleteReserveInput(ReserveInputVo reserveInputVo);
		
		int YearCopyReserveInput(ReserveInputVo reserveInputVo);
		int ConstCompMakeOutput(ReserveInputVo reserveInputVo);
		
		int MergeReserveInput(ReserveInputVo reserveInputVo);
}
