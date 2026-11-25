package com.mibbeun.amt.Controller;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibbeun.amt.Service.OutputAmtgroupInfoService;
import com.mibbeun.amt.Vo.OutputAmtgroupInfoVo;
import com.mibbeun.amt.Vo.OutputAmtgroupInfoSVo;

@RestController
@RequestMapping("/")

public class OutputAmtgroupInfoController {  
	@Autowired
	OutputAmtgroupInfoService outputAmtgroupInfoService;

	// One Select
	@RequestMapping(value="/outputAmtgroupInfoOneID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo SelectOutputAmtgroupInfoOne(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		OutputAmtgroupInfoVo inputOutputAmtgroupInfoVo = new OutputAmtgroupInfoVo();
		BeanUtils.copyProperties(outputAmtgroupInfoVo, inputOutputAmtgroupInfoVo);
		OutputAmtgroupInfoVo oneOutputAmtgroupInfoVo = outputAmtgroupInfoService.outputAmtgroupInfoOneData(inputOutputAmtgroupInfoVo);
		return oneOutputAmtgroupInfoVo;
	}

	// Select List

	@RequestMapping(value="/outputAmtgroupInfoListID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoSVo SelectOutputAmtgroupInfoList(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) { 
		OutputAmtgroupInfoVo inputOutputAmtgroupInfoVo =  new OutputAmtgroupInfoVo();
		BeanUtils.copyProperties(outputAmtgroupInfoVo, inputOutputAmtgroupInfoVo);
		List<OutputAmtgroupInfoVo> outputAmtgroupInfoListVo = outputAmtgroupInfoService.outputAmtgroupInfoListData(inputOutputAmtgroupInfoVo);
		OutputAmtgroupInfoSVo outputAmtgroupInfoSVo =  new OutputAmtgroupInfoSVo();
		outputAmtgroupInfoSVo.setOutputAmtgroupInfoListVo(outputAmtgroupInfoListVo);
		return outputAmtgroupInfoSVo;
	}

	// insert
	@RequestMapping(value="/insertOutputAmtgroupInfoID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo InsertOutputAmtgroupInfo(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) throws Exception { 
		int iResult = outputAmtgroupInfoService.insertOutputAmtgroupInfo(outputAmtgroupInfoVo);
		return outputAmtgroupInfoVo;
	}
	
	// insert
	@RequestMapping(value="/insertOutputAmtgroupInfoJsonID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo InsertOutputAmtgroupInfoJson(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(outputAmtgroupInfoVo);		
		outputAmtgroupInfoVo = outputAmtgroupInfoService.insertOutputAmtgroupInfoJson(jsonData);
		return outputAmtgroupInfoVo;
	}

	// update
	@RequestMapping(value="/updateOutputAmtgroupInfoID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo updateOutputAmtgroupInfo(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) throws Exception { 
		int iResult = outputAmtgroupInfoService.updateOutputAmtgroupInfo(outputAmtgroupInfoVo);
		return outputAmtgroupInfoVo;
	}

	// delete
	@RequestMapping(value="/deleteOutputAmtgroupInfoID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo DeleteOutputAmtgroupInfo(@RequestBody OutputAmtgroupInfoVo outputAmtgroupInfoVo ) throws Exception { 
		int iResult = outputAmtgroupInfoService.deleteOutputAmtgroupInfo(outputAmtgroupInfoVo);
		return outputAmtgroupInfoVo;
	}

	// Merge List

	@RequestMapping(value="/mergeoutputAmtgroupInfoID",method= {RequestMethod.POST})
	public OutputAmtgroupInfoVo MergeOutputAmtgroupInfoList(@RequestBody OutputAmtgroupInfoSVo outputAmtgroupInfoSVo ) { 
		int iResult = 0;
		for(OutputAmtgroupInfoVo vo : outputAmtgroupInfoSVo.getOutputAmtgroupInfoListVo()) {
			iResult = iResult + outputAmtgroupInfoService.mergeOutputAmtgroupInfo(vo);
		}
		OutputAmtgroupInfoVo outputAmtgroupInfoVo = new OutputAmtgroupInfoVo();
		BeanUtils.copyProperties(outputAmtgroupInfoSVo, outputAmtgroupInfoVo);
		return outputAmtgroupInfoVo;
	}
}