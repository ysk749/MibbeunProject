package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mibbeun.config.Vo.ReserveOutputVo;

@Mapper
public interface ReserveOutputMap {  
		ReserveOutputVo  SelectReserveOutput(ReserveOutputVo reserveOutputVo);

		List<ReserveOutputVo>  SelectReserveOutputList(ReserveOutputVo reserveOutputVo);

		int InsertReserveOutput(ReserveOutputVo reserveOutputVo);

		int UpdateReserveOutput(ReserveOutputVo reserveOutputVo);
		int DeleteReserveOutput(ReserveOutputVo reserveOutputVo);
		
		int YearCopyReserveOutput(ReserveOutputVo reserveOutputVo);
		int ConstCompMakeOutput(ReserveOutputVo reserveOutputVo);
		

		int MergeReserveOutput(ReserveOutputVo reserveOutputVo);
}
