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
import com.mibbeun.code.Service.OutputCode1Service;
import com.mibbeun.code.Vo.OutputCode1Vo;
import com.mibbeun.code.Vo.OutputCode1SVo;

@RestController
@RequestMapping("/")

public class OutputCode1Controller {  
	@Autowired
	OutputCode1Service outputCode1Service;
	@Autowired
	CodeSeqNoService codeSeqNoService;
	// One Select
	@RequestMapping(value="/outputCode1OneID",method= {RequestMethod.POST})
	public OutputCode1Vo SelectOutputCode1One(@RequestBody OutputCode1Vo outputCode1Vo ) { 
		OutputCode1Vo inputOutputCode1Vo = new OutputCode1Vo();
		BeanUtils.copyProperties(outputCode1Vo, inputOutputCode1Vo);
		OutputCode1Vo oneOutputCode1Vo = outputCode1Service.outputCode1OneData(inputOutputCode1Vo);
		return oneOutputCode1Vo;
	}

	// Select List

	@RequestMapping(value="/outputCode1ListID",method= {RequestMethod.POST})
	public OutputCode1SVo SelectOutputCode1List(@RequestBody OutputCode1Vo outputCode1Vo ) { 
		OutputCode1Vo inputOutputCode1Vo =  new OutputCode1Vo();
		BeanUtils.copyProperties(outputCode1Vo, inputOutputCode1Vo);
		List<OutputCode1Vo> outputCode1ListVo = outputCode1Service.outputCode1ListData(inputOutputCode1Vo);
		OutputCode1SVo outputCode1SVo =  new OutputCode1SVo();
		outputCode1SVo.setOutputCode1ListVo(outputCode1ListVo);
		return outputCode1SVo;
	}

	// insert
	@RequestMapping(value="/insertOutputCode1ID",method= {RequestMethod.POST})
	public OutputCode1Vo InsertOutputCode1(@RequestBody OutputCode1Vo outputCode1Vo ) throws Exception { 
		String clssCode = "지출";  
		String divisCode = "관코드"; 
		String codeGb = outputCode1Vo.getCodeGb();
		
		int iNumber = codeSeqNoService.getCodeSeqNodata(clssCode, divisCode, codeGb);
		outputCode1Vo.setCode1(iNumber);
		
		int iResult = outputCode1Service.insertOutputCode1(outputCode1Vo);
		return outputCode1Vo;
	}

	// update
	@RequestMapping(value="/updateOutputCode1ID",method= {RequestMethod.POST})
	public OutputCode1Vo updateOutputCode1(@RequestBody OutputCode1Vo outputCode1Vo ) throws Exception { 
		int iResult = outputCode1Service.updateOutputCode1(outputCode1Vo);
		return outputCode1Vo;
	}

	// delete
	@RequestMapping(value="/deleteOutputCode1ID",method= {RequestMethod.POST})
	public OutputCode1Vo DeleteOutputCode1(@RequestBody OutputCode1Vo outputCode1Vo ) throws Exception { 
		int iResult = outputCode1Service.deleteOutputCode1(outputCode1Vo);
		return outputCode1Vo;
	}	
	// Merge List

	@RequestMapping(value="/mergeoutputCode1ID",method= {RequestMethod.POST})
	public OutputCode1Vo MergeOutputCode1List(@RequestBody OutputCode1SVo outputCode1SVo ) { 
		int iResult = 0;
		for(OutputCode1Vo vo : outputCode1SVo.getOutputCode1ListVo()) {
			iResult = iResult + outputCode1Service.mergeOutputCode1(vo);
		}
		OutputCode1Vo outputCode1Vo = new OutputCode1Vo();
		BeanUtils.copyProperties(outputCode1SVo, outputCode1Vo);
		return outputCode1Vo;
	}
}
