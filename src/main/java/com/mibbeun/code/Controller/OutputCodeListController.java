package com.mibbeun.code.Controller;
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
import com.mibbeun.code.Service.OutputCodeListService;
import com.mibbeun.code.Vo.OutputCodeListVo;
import com.mibbeun.code.Vo.OutputCodeListSVo;

@RestController
@RequestMapping("/")

public class OutputCodeListController {  
	@Autowired
	OutputCodeListService outputCodeListService;

	// One Select
	@RequestMapping(value="/outputCodeListOneID",method= {RequestMethod.POST})
	public OutputCodeListVo SelectOutputCodeListOne(@RequestBody OutputCodeListVo outputCodeListVo ) { 
		OutputCodeListVo inputOutputCodeListVo = new OutputCodeListVo();
		BeanUtils.copyProperties(outputCodeListVo, inputOutputCodeListVo);
		OutputCodeListVo oneOutputCodeListVo = outputCodeListService.outputCodeListOneData(inputOutputCodeListVo);
		return oneOutputCodeListVo;
	}

	// Select List
	@RequestMapping(value="/outputCodeListListID",method= {RequestMethod.POST})
	public OutputCodeListSVo SelectOutputCodeListList(@RequestBody OutputCodeListVo outputCodeListVo ) { 
		List<OutputCodeListVo> outputCodeListListVo = outputCodeListService.outputCodeListListData(outputCodeListVo);
		OutputCodeListSVo outOutputCodeListSVo =  new OutputCodeListSVo();
		outOutputCodeListSVo.setOutputCodeListListVo(outputCodeListListVo);
		return outOutputCodeListSVo;
	}
}
