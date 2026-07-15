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
import com.mibbeun.code.Service.OutputCode3CnteService;
import com.mibbeun.code.Vo.OutputCode3CnteVo;
import com.mibbeun.code.Vo.OutputCode3CnteSVo;

@RestController
@RequestMapping("/")

public class OutputCode3CnteController {  
	@Autowired
	OutputCode3CnteService outputCode3CnteService;

	// One Select
	@RequestMapping(value="/outputCode3CnteOneID",method= {RequestMethod.POST})
	public OutputCode3CnteVo SelectOutputCode3CnteOne(@RequestBody OutputCode3CnteVo outputCode3CnteVo ) { 
		OutputCode3CnteVo inputOutputCode3CnteVo = new OutputCode3CnteVo();
		BeanUtils.copyProperties(outputCode3CnteVo, inputOutputCode3CnteVo);
		OutputCode3CnteVo oneOutputCode3CnteVo = outputCode3CnteService.outputCode3CnteOneData(inputOutputCode3CnteVo);
		return oneOutputCode3CnteVo;
	}

	// Select List

	@RequestMapping(value="/outputCode3CnteListID",method= {RequestMethod.POST})
	public OutputCode3CnteSVo SelectOutputCode3CnteList(@RequestBody OutputCode3CnteVo outputCode3CnteVo ) { 
		OutputCode3CnteVo inputOutputCode3CnteVo =  new OutputCode3CnteVo();
		BeanUtils.copyProperties(outputCode3CnteVo, inputOutputCode3CnteVo);
		List<OutputCode3CnteVo> outputCode3CnteListVo = outputCode3CnteService.outputCode3CnteListData(inputOutputCode3CnteVo);
		OutputCode3CnteSVo outputCode3CnteSVo =  new OutputCode3CnteSVo();
		outputCode3CnteSVo.setOutputCode3CnteListVo(outputCode3CnteListVo);
		return outputCode3CnteSVo;
	}

	// insert
	@RequestMapping(value="/insertOutputCode3CnteID",method= {RequestMethod.POST})
	public OutputCode3CnteVo InsertOutputCode3Cnte(@RequestBody OutputCode3CnteVo outputCode3CnteVo ) throws Exception { 
		int iResult = outputCode3CnteService.insertOutputCode3Cnte(outputCode3CnteVo);
		return outputCode3CnteVo;
	}

	// update
	@RequestMapping(value="/updateOutputCode3CnteID",method= {RequestMethod.POST})
	public OutputCode3CnteVo updateOutputCode3Cnte(@RequestBody OutputCode3CnteVo outputCode3CnteVo ) throws Exception { 
		int iResult = outputCode3CnteService.updateOutputCode3Cnte(outputCode3CnteVo);
		return outputCode3CnteVo;
	}

	// delete
	@RequestMapping(value="/deleteOutputCode3CnteID",method= {RequestMethod.POST})
	public OutputCode3CnteVo DeleteOutputCode3Cnte(@RequestBody OutputCode3CnteVo outputCode3CnteVo ) throws Exception { 
		int iResult = outputCode3CnteService.deleteOutputCode3Cnte(outputCode3CnteVo);
		return outputCode3CnteVo;
	}
	// Merge List

	@RequestMapping(value="/mergeoutputCode3CnteID",method= {RequestMethod.POST})
	public OutputCode3CnteVo MergeOutputCode3CnteList(@RequestBody OutputCode3CnteSVo outputCode3CnteSVo ) { 
		int iResult = 0;
		for(OutputCode3CnteVo vo : outputCode3CnteSVo.getOutputCode3CnteListVo()) {
			iResult = iResult + outputCode3CnteService.mergeOutputCode3Cnte(vo);
		}
		OutputCode3CnteVo outputCode3CnteVo = new OutputCode3CnteVo();
		BeanUtils.copyProperties(outputCode3CnteSVo, outputCode3CnteVo);
		return outputCode3CnteVo;
	}
}
