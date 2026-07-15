package com.mibbeun.config.Controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mibbeun.config.Service.ReserveOutputService;
import com.mibbeun.config.Vo.ReserveOutputSVo;
import com.mibbeun.config.Vo.ReserveOutputVo;

@RestController
@RequestMapping("/")

public class ReserveOutputController {  
	@Autowired
	ReserveOutputService reserveOutputService;

	// One Select
	@RequestMapping(value="/reserveOutputOneID",method= {RequestMethod.POST})
	public ReserveOutputVo SelectReserveOutputOne(@RequestBody ReserveOutputVo reserveOutputVo ) { 
		ReserveOutputVo inputReserveOutputVo = new ReserveOutputVo();
		BeanUtils.copyProperties(reserveOutputVo, inputReserveOutputVo);
		ReserveOutputVo oneReserveOutputVo = reserveOutputService.reserveOutputOneData(inputReserveOutputVo);
		return oneReserveOutputVo;
	}

	// Select List

	@RequestMapping(value="/reserveOutputListID",method= {RequestMethod.POST})
	public ReserveOutputSVo SelectReserveOutputList(@RequestBody ReserveOutputVo reserveOutputVo ) { 
		ReserveOutputVo inputReserveOutputVo =  new ReserveOutputVo();
		BeanUtils.copyProperties(reserveOutputVo, inputReserveOutputVo);
		List<ReserveOutputVo> reserveOutputListVo = reserveOutputService.reserveOutputListData(inputReserveOutputVo);
		ReserveOutputSVo reserveOutputSVo =  new ReserveOutputSVo();
		reserveOutputSVo.setReserveOutputListVo(reserveOutputListVo);
		return reserveOutputSVo;
	}

	// insert
	@RequestMapping(value="/insertReserveOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo InsertReserveOutput(@RequestBody ReserveOutputVo reserveOutputVo ) throws Exception { 
		int iResult = reserveOutputService.insertReserveOutput(reserveOutputVo);
		return reserveOutputVo;
	}

	// update
	@RequestMapping(value="/updateReserveOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo updateReserveOutput(@RequestBody ReserveOutputVo reserveOutputVo ) throws Exception { 
		int iResult = reserveOutputService.updateReserveOutput(reserveOutputVo);
		return reserveOutputVo;
	}

	// update
	@RequestMapping(value="/deleteReserveOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo deleteReserveOutput(@RequestBody ReserveOutputVo reserveOutputVo ) throws Exception { 
		int iResult = reserveOutputService.deleteReserveOutput(reserveOutputVo);
		return reserveOutputVo;
	}
	// 복사
	@RequestMapping(value="/yearCopyReserveOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo YearCopyReserveOutput(@RequestBody ReserveOutputVo reserveOutputVo ) throws Exception { 
		int iResult = reserveOutputService.yearCopyReserveOutput(reserveOutputVo);
		return reserveOutputVo;
	}
	
	// 복사
	@RequestMapping(value="/constCompMakeOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo ConstCompMakeOutput(@RequestBody ReserveOutputVo reserveOutputVo ) throws Exception { 
		int iResult = reserveOutputService.constCompMakeOutput(reserveOutputVo);
		return reserveOutputVo;
	}	
		
	
	
	// Merge List

	@RequestMapping(value="/mergereserveOutputID",method= {RequestMethod.POST})
	public ReserveOutputVo MergeReserveOutputList(@RequestBody ReserveOutputSVo reserveOutputSVo ) { 
		int iResult = 0;
		for(ReserveOutputVo vo : reserveOutputSVo.getReserveOutputListVo()) {
			iResult = iResult + reserveOutputService.mergeReserveOutput(vo);
		}
		ReserveOutputVo reserveOutputVo = new ReserveOutputVo();
		BeanUtils.copyProperties(reserveOutputSVo, reserveOutputVo);
		return reserveOutputVo;
	}
}
