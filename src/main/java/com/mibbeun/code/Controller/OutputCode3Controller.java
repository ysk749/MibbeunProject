package com.mibbeun.code.Controller;
import java.io.IOException;
import java.sql.SQLException;
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
import com.mibbeun.code.Service.OutputCode3Service;
import com.mibbeun.code.Vo.OutputCode3Vo;
import com.mibbeun.code.Vo.OutputCode3SVo;

@RestController
@RequestMapping("/")

public class OutputCode3Controller {  
	@Autowired
	OutputCode3Service outputCode3Service;
	@Autowired
	CodeSeqNoService codeSeqNoService;
	// One Select
	@RequestMapping(value="/outputCode3OneID",method= {RequestMethod.POST})
	public OutputCode3Vo SelectOutputCode3One(@RequestBody OutputCode3Vo outputCode3Vo ) { 
		OutputCode3Vo inputOutputCode3Vo = new OutputCode3Vo();
		BeanUtils.copyProperties(outputCode3Vo, inputOutputCode3Vo);
		OutputCode3Vo oneOutputCode3Vo = outputCode3Service.outputCode3OneData(inputOutputCode3Vo);
		return oneOutputCode3Vo;
	}

	// Select List

	@RequestMapping(value="/outputCode3ListID",method= {RequestMethod.POST})
	public OutputCode3SVo SelectOutputCode3List(@RequestBody OutputCode3Vo outputCode3Vo ) { 
		OutputCode3Vo inputOutputCode3Vo =  new OutputCode3Vo();
		BeanUtils.copyProperties(outputCode3Vo, inputOutputCode3Vo);
		List<OutputCode3Vo> outputCode3ListVo = outputCode3Service.outputCode3ListData(inputOutputCode3Vo);
		OutputCode3SVo outputCode3SVo =  new OutputCode3SVo();
		outputCode3SVo.setOutputCode3ListVo(outputCode3ListVo);
		return outputCode3SVo;
	}

	// insert
	@RequestMapping(value="/insertOutputCode3ID",method= {RequestMethod.POST})
	public OutputCode3Vo InsertOutputCode3(@RequestBody OutputCode3Vo outputCode3Vo ) throws SQLException { 
		String clssCode = "지출";  
		String divisCode = "목코드"; 
		String codeGb = outputCode3Vo.getCodeGb();
		
		int iNumber = codeSeqNoService.getCodeSeqNodata(clssCode, divisCode, codeGb);
		outputCode3Vo.setCode3(iNumber);			
		int iResult = outputCode3Service.insertOutputCode3(outputCode3Vo);
		return outputCode3Vo;
	}

	// update
	@RequestMapping(value="/updateOutputCode3ID",method= {RequestMethod.POST})
	public OutputCode3Vo updateOutputCode3(@RequestBody OutputCode3Vo outputCode3Vo ) throws SQLException { 
		int iResult = outputCode3Service.updateOutputCode3(outputCode3Vo);
		return outputCode3Vo;
	}

	// update
	@RequestMapping(value="/deleteOutputCode3ID",method= {RequestMethod.POST})
	public OutputCode3Vo DeleteOutputCode3(@RequestBody OutputCode3Vo outputCode3Vo ) throws SQLException { 
		int iResult = outputCode3Service.deleteOutputCode3(outputCode3Vo);
		return outputCode3Vo;
	}
	
	// Merge List

	@RequestMapping(value="/mergeoutputCode3ID",method= {RequestMethod.POST})
	public OutputCode3Vo MergeOutputCode3List(@RequestBody OutputCode3SVo outputCode3SVo ) { 
		int iResult = 0;
		for(OutputCode3Vo vo : outputCode3SVo.getOutputCode3ListVo()) {
			iResult = iResult + outputCode3Service.mergeOutputCode3(vo);
		}
		OutputCode3Vo outputCode3Vo = new OutputCode3Vo();
		BeanUtils.copyProperties(outputCode3SVo, outputCode3Vo);
		return outputCode3Vo;
	}
}
