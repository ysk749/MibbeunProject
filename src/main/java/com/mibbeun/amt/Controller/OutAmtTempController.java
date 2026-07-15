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
import com.mibbeun.amt.Service.OutAmtTempService;
import com.mibbeun.amt.Vo.OutAmtTempVo;
import com.mibbeun.amt.Vo.OutAmtTempSVo;

@RestController
@RequestMapping("/")

public class OutAmtTempController {  
	@Autowired
	OutAmtTempService outAmtTempService;

	// One Select
	@RequestMapping(value="/outAmtTempOneID",method= {RequestMethod.POST})
	public OutAmtTempVo SelectOutAmtTempOne(@RequestBody OutAmtTempVo outAmtTempVo ) { 
		OutAmtTempVo inputOutAmtTempVo = new OutAmtTempVo();
		BeanUtils.copyProperties(outAmtTempVo, inputOutAmtTempVo);
		OutAmtTempVo oneOutAmtTempVo = outAmtTempService.outAmtTempOneData(inputOutAmtTempVo);
		return oneOutAmtTempVo;
	}

	// Select List

	@RequestMapping(value="/outAmtTempListID",method= {RequestMethod.POST})
	public OutAmtTempSVo SelectOutAmtTempList(@RequestBody OutAmtTempVo outAmtTempVo ) { 
		OutAmtTempVo inputOutAmtTempVo =  new OutAmtTempVo();
		BeanUtils.copyProperties(outAmtTempVo, inputOutAmtTempVo);
		List<OutAmtTempVo> outAmtTempListVo = outAmtTempService.outAmtTempListData(inputOutAmtTempVo);
		OutAmtTempSVo outAmtTempSVo =  new OutAmtTempSVo();
		outAmtTempSVo.setOutAmtTempListVo(outAmtTempListVo);
		return outAmtTempSVo;
	}

	// insert
	@RequestMapping(value="/insertOutAmtTempID",method= {RequestMethod.POST})
	public OutAmtTempVo InsertOutAmtTemp(@RequestBody OutAmtTempVo outAmtTempVo ) throws Exception { 
		int iResult = outAmtTempService.insertOutAmtTemp(outAmtTempVo);
		return outAmtTempVo;
	}

	// update
	@RequestMapping(value="/updateOutAmtTempID",method= {RequestMethod.POST})
	public OutAmtTempVo updateOutAmtTemp(@RequestBody OutAmtTempVo outAmtTempVo ) throws Exception { 
		int iResult = outAmtTempService.updateOutAmtTemp(outAmtTempVo);
		return outAmtTempVo;
	}

	// delete
	@RequestMapping(value="/deleteOutAmtTempID",method= {RequestMethod.POST})
	public OutAmtTempVo DeleteOutAmtTemp(@RequestBody OutAmtTempVo outAmtTempVo ) throws Exception { 
		int iResult = outAmtTempService.deleteOutAmtTemp(outAmtTempVo);
		return outAmtTempVo;
	}
	// 처리완료
	@RequestMapping(value="/updateUsrAmtTempID",method= {RequestMethod.POST})
	public OutAmtTempVo UpdateUsrAmtTemp(@RequestBody OutAmtTempVo outAmtTempVo ) throws Exception { 
		int iResult = outAmtTempService.updateUsrAmtTemp(outAmtTempVo);
		return outAmtTempVo;
	}	
	
	@RequestMapping(value="/outAmtTempInsertListID",method= {RequestMethod.POST})
	public OutAmtTempVo outAmtTempInsertList(@RequestBody OutAmtTempSVo outAmtTempSVo ) { 
		int iResult = 0;
		for(OutAmtTempVo vo : outAmtTempSVo.getOutAmtTempListVo()) {
			iResult = iResult + outAmtTempService.insertOutAmtTemp(vo);
		}
		OutAmtTempVo outAmtTempVo = new OutAmtTempVo();
		BeanUtils.copyProperties(outAmtTempSVo, outAmtTempVo);
		return outAmtTempVo;
	}
	
	// Merge List

	@RequestMapping(value="/mergeoutAmtTempID",method= {RequestMethod.POST})
	public OutAmtTempVo MergeOutAmtTempList(@RequestBody OutAmtTempSVo outAmtTempSVo ) { 
		int iResult = 0;
		for(OutAmtTempVo vo : outAmtTempSVo.getOutAmtTempListVo()) {
			iResult = iResult + outAmtTempService.mergeOutAmtTemp(vo);
		}
		OutAmtTempVo outAmtTempVo = new OutAmtTempVo();
		BeanUtils.copyProperties(outAmtTempSVo, outAmtTempVo);
		return outAmtTempVo;
	}
}
