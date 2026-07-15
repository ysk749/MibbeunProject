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

import com.mibbeun.config.Service.ReserveInputService;
import com.mibbeun.config.Vo.ReserveInputSVo;
import com.mibbeun.config.Vo.ReserveInputVo;
import com.mibbeun.config.Vo.ReserveOutputVo;

@RestController
@RequestMapping("/")

public class ReserveInputController {  
	@Autowired
	ReserveInputService reserveInputService;

	// One Select
	@RequestMapping(value="/reserveInputOneID",method= {RequestMethod.POST})
	public ReserveInputVo SelectReserveInputOne(@RequestBody ReserveInputVo reserveInputVo ) { 
		ReserveInputVo inputReserveInputVo = new ReserveInputVo();
		BeanUtils.copyProperties(reserveInputVo, inputReserveInputVo);
		ReserveInputVo oneReserveInputVo = reserveInputService.reserveInputOneData(inputReserveInputVo);
		return oneReserveInputVo;
	}

	// Select List

	@RequestMapping(value="/reserveInputListID",method= {RequestMethod.POST})
	public ReserveInputSVo SelectReserveInputList(@RequestBody ReserveInputVo reserveInputVo ) { 
		ReserveInputVo inputReserveInputVo =  new ReserveInputVo();
		BeanUtils.copyProperties(reserveInputVo, inputReserveInputVo);
		List<ReserveInputVo> reserveInputListVo = reserveInputService.reserveInputListData(inputReserveInputVo);
		ReserveInputSVo reserveInputSVo =  new ReserveInputSVo();
		reserveInputSVo.setReserveInputListVo(reserveInputListVo);
		return reserveInputSVo;
	}

	// insert
	@RequestMapping(value="/insertReserveInputID",method= {RequestMethod.POST})
	public ReserveInputVo InsertReserveInput(@RequestBody ReserveInputVo reserveInputVo ) throws Exception { 
		int iResult = reserveInputService.insertReserveInput(reserveInputVo);
		return reserveInputVo;
	}

	// update
	@RequestMapping(value="/updateReserveInputID",method= {RequestMethod.POST})
	public ReserveInputVo updateReserveInput(@RequestBody ReserveInputVo reserveInputVo ) throws Exception { 
		int iResult = reserveInputService.updateReserveInput(reserveInputVo);
		return reserveInputVo;
	}

	// update
	@RequestMapping(value="/deleteReserveInputID",method= {RequestMethod.POST})
	public ReserveInputVo deleteReserveInput(@RequestBody ReserveInputVo reserveInputVo ) throws Exception { 
		int iResult = reserveInputService.deleteReserveInput(reserveInputVo);
		return reserveInputVo;
	}
	
	// 복사
	@RequestMapping(value="/yearCopyReserveInputID",method= {RequestMethod.POST})
	public ReserveInputVo YearCopyReserveInput(@RequestBody ReserveInputVo reserveInputVo ) throws Exception { 
		int iResult = reserveInputService.yearCopyReserveInput(reserveInputVo);
		return reserveInputVo;
	}
	
	// 복사
	@RequestMapping(value="/constCompMakeInputID",method= {RequestMethod.POST})
	public ReserveInputVo ConstCompMakeInput(@RequestBody ReserveInputVo reserveInputVo ) throws Exception { 
		int iResult = reserveInputService.constCompMakeOutput(reserveInputVo);
		return reserveInputVo;
	}
		
	// Merge List
	@RequestMapping(value="/mergereserveInputID",method= {RequestMethod.POST})
	public ReserveInputVo MergeReserveInputList(@RequestBody ReserveInputSVo reserveInputSVo ) { 
		int iResult = 0;
		for(ReserveInputVo vo : reserveInputSVo.getReserveInputListVo()) {
			iResult = iResult + reserveInputService.mergeReserveInput(vo);
		}
		ReserveInputVo reserveInputVo = new ReserveInputVo();
		BeanUtils.copyProperties(reserveInputSVo, reserveInputVo);
		return reserveInputVo;
	}
}
