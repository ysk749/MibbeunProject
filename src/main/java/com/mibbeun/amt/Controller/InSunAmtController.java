package com.mibbeun.amt.Controller;
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
import com.mibbeun.amt.Service.InSunAmtService;
import com.mibbeun.amt.Vo.InSunAmtVo;
import com.mibbeun.amt.Vo.InSunAmtSVo;

@RestController
@RequestMapping("/")

public class InSunAmtController {  
	@Autowired
	InSunAmtService inSunAmtService;

	// One Select
	@RequestMapping(value="/inSunAmtOneID",method= {RequestMethod.POST})
	public InSunAmtVo SelectInSunAmtOne(@RequestBody InSunAmtVo inSunAmtVo ) { 
		InSunAmtVo inputInSunAmtVo = new InSunAmtVo();
		BeanUtils.copyProperties(inSunAmtVo, inputInSunAmtVo);
		InSunAmtVo oneInSunAmtVo = inSunAmtService.inSunAmtOneData(inputInSunAmtVo);
		return oneInSunAmtVo;
	}
	
	// One Select
	@RequestMapping(value="/sumInSunAmtID",method= {RequestMethod.POST})
	public InSunAmtVo SumInSunAmt(@RequestBody InSunAmtVo inSunAmtVo ) { 
		InSunAmtVo inputInSunAmtVo = new InSunAmtVo();
		BeanUtils.copyProperties(inSunAmtVo, inputInSunAmtVo);
		InSunAmtVo oneInSunAmtVo = inSunAmtService.sumInSunAmt(inputInSunAmtVo);
		return oneInSunAmtVo;
	}	
	
	

	// Select List

	@RequestMapping(value="/inSunAmtListID",method= {RequestMethod.POST})
	public InSunAmtSVo SelectInSunAmtList(@RequestBody InSunAmtVo inSunAmtVo ) { 
		InSunAmtVo inputInSunAmtVo =  new InSunAmtVo();
		BeanUtils.copyProperties(inSunAmtVo, inputInSunAmtVo);
		List<InSunAmtVo> inSunAmtListVo = inSunAmtService.inSunAmtListData(inputInSunAmtVo);
		InSunAmtSVo inSunAmtSVo =  new InSunAmtSVo();
		inSunAmtSVo.setInSunAmtListVo(inSunAmtListVo);
		return inSunAmtSVo;
	}

	// insert
	@RequestMapping(value="/insertInSunAmtID",method= {RequestMethod.POST})
	public InSunAmtVo InsertInSunAmt(@RequestBody InSunAmtVo inSunAmtVo ) throws Exception { 
		int iResult = inSunAmtService.insertInSunAmt(inSunAmtVo);
		return inSunAmtVo;
	}
	
	

	// update
	@RequestMapping(value="/updateInSunAmtID",method= {RequestMethod.POST})
	public InSunAmtVo updateInSunAmt(@RequestBody InSunAmtVo inSunAmtVo ) throws Exception { 
		int iResult = inSunAmtService.updateInSunAmt(inSunAmtVo);
		return inSunAmtVo;
	}
	
	// update
	@RequestMapping(value="/deleteInSunAmtID",method= {RequestMethod.POST})
	public InSunAmtVo deleteInSunAmt(@RequestBody InSunAmtVo inSunAmtVo ) throws Exception { 
		int iResult = inSunAmtService.updateInSunAmt(inSunAmtVo);
		return inSunAmtVo;
	}
	

	// Merge List

	@RequestMapping(value="/mergeinSunAmtID",method= {RequestMethod.POST})
	public InSunAmtVo MergeInSunAmtList(@RequestBody InSunAmtSVo inSunAmtSVo ) { 
		int iResult = 0;
		for(InSunAmtVo vo : inSunAmtSVo.getInSunAmtListVo()) {
			iResult = iResult + inSunAmtService.mergeInSunAmt(vo);
		}
		InSunAmtVo inSunAmtVo = new InSunAmtVo();
		BeanUtils.copyProperties(inSunAmtSVo, inSunAmtVo);
		return inSunAmtVo;
	}
}
