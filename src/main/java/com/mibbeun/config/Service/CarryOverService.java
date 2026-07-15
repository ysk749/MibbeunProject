package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.config.Map.CarryOverMap;
import com.mibbeun.config.Vo.CarryOverVo;

@Service
public class CarryOverService {  
	@Autowired
	CarryOverMap carryOverMap;

	// One Select
	public CarryOverVo carryOverOneData(CarryOverVo carryOverVo ) { 
		return carryOverMap.SelectCarryOver(carryOverVo);
	}
	// List Select
	public List<CarryOverVo> carryOverListData(CarryOverVo carryOverVo ) { 
		return carryOverMap.SelectCarryOverList(carryOverVo);
	}
	// insert
	public int insertCarryOver(CarryOverVo carryOverVo ) { 
		return carryOverMap.InsertCarryOver(carryOverVo);
	}
	// update
	public int updateCarryOver(CarryOverVo carryOverVo ) { 
		return carryOverMap.UpdateCarryOver(carryOverVo);
	}
	
	// delete
	public int deleteCarryOver(CarryOverVo carryOverVo ) { 
		return carryOverMap.DeleteCarryOver(carryOverVo);
	}
	
	// Merge
	public int mergeCarryOver(CarryOverVo carryOverVo ) { 
		return carryOverMap.MergeCarryOver(carryOverVo);
	}
}
