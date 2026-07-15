package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mibbeun.config.Map.ReserveOutputMap;
import com.mibbeun.config.Vo.ReserveOutputVo;

@Service
public class ReserveOutputService {  
	@Autowired
	ReserveOutputMap reserveOutputMap;

	// One Select
	public ReserveOutputVo reserveOutputOneData(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.SelectReserveOutput(reserveOutputVo);
	}
	// List Select
	public List<ReserveOutputVo> reserveOutputListData(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.SelectReserveOutputList(reserveOutputVo);
	}
	// insert
	public int insertReserveOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.InsertReserveOutput(reserveOutputVo);
	}
	// update
	public int updateReserveOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.UpdateReserveOutput(reserveOutputVo);
	}
	// delete
	public int deleteReserveOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.DeleteReserveOutput(reserveOutputVo);
	}	
	
	// delete
	public int yearCopyReserveOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.YearCopyReserveOutput(reserveOutputVo);
	}	
	
	public int constCompMakeOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.ConstCompMakeOutput(reserveOutputVo);
	}		
	
	
	// Merge
	public int mergeReserveOutput(ReserveOutputVo reserveOutputVo ) { 
		return reserveOutputMap.MergeReserveOutput(reserveOutputVo);
	}
}
