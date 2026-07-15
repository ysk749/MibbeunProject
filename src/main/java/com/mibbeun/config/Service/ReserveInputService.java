package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mibbeun.config.Map.ReserveInputMap;
import com.mibbeun.config.Vo.ReserveInputVo;

@Service
public class ReserveInputService {  
	@Autowired
	ReserveInputMap reserveInputMap;

	// One Select
	public ReserveInputVo reserveInputOneData(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.SelectReserveInput(reserveInputVo);
	}
	// List Select
	public List<ReserveInputVo> reserveInputListData(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.SelectReserveInputList(reserveInputVo);
	}
	// insert
	public int insertReserveInput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.InsertReserveInput(reserveInputVo);
	}
	// update
	public int updateReserveInput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.UpdateReserveInput(reserveInputVo);
	}

	// update
	public int deleteReserveInput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.DeleteReserveInput(reserveInputVo);
	}

	
	public int yearCopyReserveInput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.YearCopyReserveInput(reserveInputVo);
	}

	public int constCompMakeOutput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.ConstCompMakeOutput(reserveInputVo);
	}
	
		
	
	// Merge
	public int mergeReserveInput(ReserveInputVo reserveInputVo ) { 
		return reserveInputMap.MergeReserveInput(reserveInputVo);
	}
}
