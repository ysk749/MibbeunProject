package com.mibbeun.code.Controller;
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

import com.mibbeun.code.Service.CodeSeqNoService;
import com.mibbeun.code.Service.OutputCode2Service;
import com.mibbeun.code.Vo.OutputCode2Vo;
import com.mibbeun.code.Vo.OutputCode2SVo;

@RestController
@RequestMapping("/")

public class OutputCode2Controller {  
	@Autowired
	OutputCode2Service outputCode2Service;
	@Autowired
	CodeSeqNoService codeSeqNoService;
	// One Select
	@RequestMapping(value="/outputCode2OneID",method= {RequestMethod.POST})
	public OutputCode2Vo SelectOutputCode2One(@RequestBody OutputCode2Vo outputCode2Vo ) { 
		OutputCode2Vo inputOutputCode2Vo = new OutputCode2Vo();
		BeanUtils.copyProperties(outputCode2Vo, inputOutputCode2Vo);
		OutputCode2Vo oneOutputCode2Vo = outputCode2Service.outputCode2OneData(inputOutputCode2Vo);
		return oneOutputCode2Vo;
	}

	// Select List

	@RequestMapping(value="/outputCode2ListID",method= {RequestMethod.POST})
	public OutputCode2SVo SelectOutputCode2List(@RequestBody OutputCode2Vo outputCode2Vo ) { 
		OutputCode2Vo inputOutputCode2Vo =  new OutputCode2Vo();
		BeanUtils.copyProperties(outputCode2Vo, inputOutputCode2Vo);
		List<OutputCode2Vo> outputCode2ListVo = outputCode2Service.outputCode2ListData(inputOutputCode2Vo);
		OutputCode2SVo outputCode2SVo =  new OutputCode2SVo();
		outputCode2SVo.setOutputCode2ListVo(outputCode2ListVo);
		return outputCode2SVo;
	}

	// insert
	@RequestMapping(value="/insertOutputCode2ID",method= {RequestMethod.POST})
	public OutputCode2Vo InsertOutputCode2(@RequestBody OutputCode2Vo outputCode2Vo ) throws Exception { 
		String clssCode = "지출";  
		String divisCode = "항코드"; 
		String codeGb = outputCode2Vo.getCodeGb();
		
		int iNumber = codeSeqNoService.getCodeSeqNodata(clssCode, divisCode, codeGb);
		outputCode2Vo.setCode2(iNumber);		
		int iResult = outputCode2Service.insertOutputCode2(outputCode2Vo);
		return outputCode2Vo;
	}

	// update
	@RequestMapping(value="/updateOutputCode2ID",method= {RequestMethod.POST})
	public OutputCode2Vo updateOutputCode2(@RequestBody OutputCode2Vo outputCode2Vo ) throws Exception { 
		int iResult = outputCode2Service.updateOutputCode2(outputCode2Vo);
		return outputCode2Vo;
	}
	
	// update
	@RequestMapping(value="/deleteOutputCode2ID",method= {RequestMethod.POST})
	public OutputCode2Vo DeleteOutputCode2(@RequestBody OutputCode2Vo outputCode2Vo ) throws Exception { 
		int iResult = outputCode2Service.deleteOutputCode2(outputCode2Vo);
		return outputCode2Vo;
	}

	// Merge List

	@RequestMapping(value="/mergeoutputCode2ID",method= {RequestMethod.POST})
	public OutputCode2Vo MergeOutputCode2List(@RequestBody OutputCode2SVo outputCode2SVo ) { 
		int iResult = 0;
		for(OutputCode2Vo vo : outputCode2SVo.getOutputCode2ListVo()) {
			iResult = iResult + outputCode2Service.mergeOutputCode2(vo);
		}
		OutputCode2Vo outputCode2Vo = new OutputCode2Vo();
		BeanUtils.copyProperties(outputCode2SVo, outputCode2Vo);
		return outputCode2Vo;
	}
}
