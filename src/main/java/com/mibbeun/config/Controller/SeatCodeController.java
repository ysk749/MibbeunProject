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
import com.mibbeun.config.Service.SeatCodeService;
import com.mibbeun.config.Vo.SeatCodeVo;
import com.mibbeun.config.Vo.SeatCodeSVo;

@RestController
@RequestMapping("/")

public class SeatCodeController {  
	@Autowired
	SeatCodeService seatCodeService;

	// One Select
	@RequestMapping(value="/seatCodeOneID",method= {RequestMethod.POST})
	public SeatCodeVo SelectSeatCodeOne(@RequestBody SeatCodeVo seatCodeVo ) { 
		SeatCodeVo inputSeatCodeVo = new SeatCodeVo();
		BeanUtils.copyProperties(seatCodeVo, inputSeatCodeVo);
		SeatCodeVo oneSeatCodeVo = seatCodeService.seatCodeOneData(inputSeatCodeVo);
		return oneSeatCodeVo;
	}

	// Select List

	@RequestMapping(value="/seatCodeListID",method= {RequestMethod.POST})
	public SeatCodeSVo SelectSeatCodeList(@RequestBody SeatCodeVo seatCodeVo ) { 
		SeatCodeVo inputSeatCodeVo =  new SeatCodeVo();
		BeanUtils.copyProperties(seatCodeVo, inputSeatCodeVo);
		List<SeatCodeVo> seatCodeListVo = seatCodeService.seatCodeListData(inputSeatCodeVo);
		SeatCodeSVo seatCodeSVo =  new SeatCodeSVo();
		seatCodeSVo.setSeatCodeListVo(seatCodeListVo);
		return seatCodeSVo;
	}
	
	@RequestMapping(value="/seatCodeInsertCheckListID",method= {RequestMethod.POST})
	public SeatCodeSVo SeatCodeInsertCheckList(@RequestBody SeatCodeVo seatCodeVo ) { 
		SeatCodeVo inputSeatCodeVo =  new SeatCodeVo();
		BeanUtils.copyProperties(seatCodeVo, inputSeatCodeVo);
		List<SeatCodeVo> seatCodeListVo = seatCodeService.seatCodeInsertCheckListData(inputSeatCodeVo);
		SeatCodeSVo seatCodeSVo =  new SeatCodeSVo();
		seatCodeSVo.setSeatCodeListVo(seatCodeListVo);
		return seatCodeSVo;
	}
		
	@RequestMapping(value="/seatCodeInsertCheckList2ID",method= {RequestMethod.POST})
	public SeatCodeSVo SeatCodeInsertCheckList2(@RequestBody SeatCodeVo seatCodeVo ) { 
		SeatCodeVo inputSeatCodeVo =  new SeatCodeVo();
		BeanUtils.copyProperties(seatCodeVo, inputSeatCodeVo);
		List<SeatCodeVo> seatCodeListVo = seatCodeService.seatCodeInsertCheckListData2(inputSeatCodeVo);
		SeatCodeSVo seatCodeSVo =  new SeatCodeSVo();
		seatCodeSVo.setSeatCodeListVo(seatCodeListVo);
		return seatCodeSVo;
	}
			
	@RequestMapping(value="/BeforCopyInsertSeatCodeID",method= {RequestMethod.POST})
	public SeatCodeVo BeforCopyInsertSeatCode(@RequestBody SeatCodeVo seatCodeVo ) throws Exception { 
		int iResult = seatCodeService.beforCopyInsertSeatCode(seatCodeVo);
		return seatCodeVo;
	}	
	// insert
	@RequestMapping(value="/insertSeatCodeID",method= {RequestMethod.POST})
	public SeatCodeVo InsertSeatCode(@RequestBody SeatCodeVo seatCodeVo ) throws Exception { 
		int iResult = seatCodeService.insertSeatCode(seatCodeVo);
		return seatCodeVo;
	}

	// update
	@RequestMapping(value="/updateSeatCodeID",method= {RequestMethod.POST})
	public SeatCodeVo updateSeatCode(@RequestBody SeatCodeVo seatCodeVo ) throws Exception { 
		int iResult = seatCodeService.updateSeatCode(seatCodeVo);
		return seatCodeVo;
	}

	// delete
	@RequestMapping(value="/deleteSeatCodeID",method= {RequestMethod.POST})
	public SeatCodeVo DeleteSeatCode(@RequestBody SeatCodeVo seatCodeVo ) throws Exception { 
		int iResult = seatCodeService.deleteSeatCode(seatCodeVo);
		return seatCodeVo;
	}

	// Merge List

	@RequestMapping(value="/mergeseatCodeID",method= {RequestMethod.POST})
	public SeatCodeVo MergeSeatCodeList(@RequestBody SeatCodeSVo seatCodeSVo ) { 
		int iResult = 0;
		for(SeatCodeVo vo : seatCodeSVo.getSeatCodeListVo()) {
			iResult = iResult + seatCodeService.mergeSeatCode(vo);
		}
		SeatCodeVo seatCodeVo = new SeatCodeVo();
		BeanUtils.copyProperties(seatCodeSVo, seatCodeVo);
		return seatCodeVo;
	}
}