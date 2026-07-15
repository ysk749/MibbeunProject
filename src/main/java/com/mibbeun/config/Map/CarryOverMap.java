package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.config.Vo.CarryOverVo;

@Mapper
public interface CarryOverMap {  
		CarryOverVo  SelectCarryOver(CarryOverVo carryOverVo);

		List<CarryOverVo>  SelectCarryOverList(CarryOverVo carryOverVo);

		int InsertCarryOver(CarryOverVo carryOverVo);

		int UpdateCarryOver(CarryOverVo carryOverVo);
		int DeleteCarryOver(CarryOverVo carryOverVo);
		int MergeCarryOver(CarryOverVo carryOverVo);
}
