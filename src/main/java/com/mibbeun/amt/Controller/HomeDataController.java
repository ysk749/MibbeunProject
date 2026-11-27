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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibbeun.amt.Service.OutAmtService;
import com.mibbeun.amt.Vo.OutAmtVo;
import com.mibbeun.amt.Vo.OutputAmtgroupItemVo;
import com.mibbeun.amt.Vo.OutAmtSVo;

@RestController
@RequestMapping("/")

public class HomeDataController {  
	@Autowired
	OutAmtService outAmtService;
	
	@RequestMapping(value="/OtherDataInsertAmtID",method= {RequestMethod.POST})
	public OutAmtVo OtherDataInsertAmt(@RequestBody OutAmtVo outAmtVo ) throws Exception { 
		int iResult = outAmtService.deleteOutOtherDataAmt(outAmtVo);
		iResult = outAmtService.insertOutOtherDataAmt(outAmtVo);
		return outAmtVo;
	}

	// One Select
	@RequestMapping(value="/outAmtOneID",method= {RequestMethod.POST})
	public OutAmtVo SelectOutAmtOne(@RequestBody OutAmtVo outAmtVo ) { 
		OutAmtVo inputOutAmtVo = new OutAmtVo();
		BeanUtils.copyProperties(outAmtVo, inputOutAmtVo);
		OutAmtVo oneOutAmtVo = outAmtService.outAmtOneData(inputOutAmtVo);
		return oneOutAmtVo;
	}

	// Select List

	@RequestMapping(value="/outAmtListID",method= {RequestMethod.POST})
	public OutAmtSVo SelectOutAmtList(@RequestBody OutAmtVo outAmtVo ) { 
		OutAmtVo inputOutAmtVo =  new OutAmtVo();
		BeanUtils.copyProperties(outAmtVo, inputOutAmtVo);
		List<OutAmtVo> outAmtListVo = outAmtService.outAmtListData(inputOutAmtVo);
		OutAmtSVo outAmtSVo =  new OutAmtSVo();
		outAmtSVo.setOutAmtListVo(outAmtListVo);
		return outAmtSVo;
	}

	// insert
	@RequestMapping(value="/insertOutAmtID",method= {RequestMethod.POST})
	public OutAmtVo InsertOutAmt(@RequestBody OutAmtVo outAmtVo ) throws Exception { 
		int iResult = outAmtService.insertOutAmt(outAmtVo);
		return outAmtVo;
	}
	
	// update Group에 있는것 처리
	@RequestMapping(value="groupItemToInsertOutAmtJsonID",method= {RequestMethod.POST})
	public OutAmtVo GroupItemToInsertOutAmtJsonID(@RequestBody OutAmtVo outAmtVo ) throws Exception { 
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(outAmtVo);		
		int iCode = outAmtService.groupItemToInsertOutAmtJson(jsonData);
		outAmtVo.setCode(iCode);
		return outAmtVo;
	}
	
	// update
	@RequestMapping(value="/updateOutAmtID",method= {RequestMethod.POST})
	public OutAmtVo updateOutAmt(@RequestBody OutAmtVo outAmtVo ) throws Exception { 
		int iResult = outAmtService.updateOutAmt(outAmtVo);
		return outAmtVo;
	}

	@RequestMapping(value="/deleteOutAmtID",method= {RequestMethod.POST})
	public OutAmtVo deleteOutAmt(@RequestBody OutAmtVo outAmtVo ) throws Exception { 
		int iResult = outAmtService.deleteOutAmt(outAmtVo);
		return outAmtVo;
	}
	// Merge List

	@RequestMapping(value="/mergeoutAmtID",method= {RequestMethod.POST})
	public OutAmtVo MergeOutAmtList(@RequestBody OutAmtSVo outAmtSVo ) { 
		int iResult = 0;
		for(OutAmtVo vo : outAmtSVo.getOutAmtListVo()) {
			iResult = iResult + outAmtService.mergeOutAmt(vo);
		}
		OutAmtVo outAmtVo = new OutAmtVo();
		BeanUtils.copyProperties(outAmtSVo, outAmtVo);
		return outAmtVo;
	}
}
