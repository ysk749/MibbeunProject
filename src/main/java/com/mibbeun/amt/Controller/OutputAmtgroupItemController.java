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
import com.mibbeun.amt.Service.OutputAmtgroupItemService;
import com.mibbeun.amt.Vo.OutputAmtgroupItemVo;
import com.mibbeun.amt.Vo.OutAmtBefoVo;
import com.mibbeun.amt.Vo.OutputAmtgroupItemSVo;

@RestController
@RequestMapping("/")

public class OutputAmtgroupItemController {  
	@Autowired
	OutputAmtgroupItemService outputAmtgroupItemService;

	// One Select
	@RequestMapping(value="/outputAmtgroupItemOneID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo SelectOutputAmtgroupItemOne(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		OutputAmtgroupItemVo inputOutputAmtgroupItemVo = new OutputAmtgroupItemVo();
		BeanUtils.copyProperties(outputAmtgroupItemVo, inputOutputAmtgroupItemVo);
		OutputAmtgroupItemVo oneOutputAmtgroupItemVo = outputAmtgroupItemService.outputAmtgroupItemOneData(inputOutputAmtgroupItemVo);
		return oneOutputAmtgroupItemVo;
	}

	// Select List

	@RequestMapping(value="/outputAmtgroupItemListID",method= {RequestMethod.POST})
	public OutputAmtgroupItemSVo SelectOutputAmtgroupItemList(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) { 
		OutputAmtgroupItemVo inputOutputAmtgroupItemVo =  new OutputAmtgroupItemVo();
		BeanUtils.copyProperties(outputAmtgroupItemVo, inputOutputAmtgroupItemVo);
		List<OutputAmtgroupItemVo> outputAmtgroupItemListVo = outputAmtgroupItemService.outputAmtgroupItemListData(inputOutputAmtgroupItemVo);
		OutputAmtgroupItemSVo outputAmtgroupItemSVo =  new OutputAmtgroupItemSVo();
		outputAmtgroupItemSVo.setOutputAmtgroupItemListVo(outputAmtgroupItemListVo);
		return outputAmtgroupItemSVo;
	}

	// insert
	@RequestMapping(value="/insertOutputAmtgroupItemID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo InsertOutputAmtgroupItem(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) throws Exception { 
		int iResult = outputAmtgroupItemService.insertOutputAmtgroupItem(outputAmtgroupItemVo);
		return outputAmtgroupItemVo;
	}

	// JSON INSERT
	@RequestMapping(value="/insertOutputAmtgroupItemJsonID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo InsertOutputAmtgroupItemJson(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) throws Exception { 
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonData = objectMapper.writeValueAsString(outputAmtgroupItemVo);		
		outputAmtgroupItemVo = outputAmtgroupItemService.insertOutputAmtgroupItemJson(jsonData);
		return outputAmtgroupItemVo;
	}

	
	// update
	@RequestMapping(value="/updateOutputAmtgroupItemID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo updateOutputAmtgroupItem(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) throws Exception { 
		int iResult = outputAmtgroupItemService.updateOutputAmtgroupItem(outputAmtgroupItemVo);
		return outputAmtgroupItemVo;
	}

	// delete
	@RequestMapping(value="/deleteOutputAmtgroupItemID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo DeleteOutputAmtgroupItem(@RequestBody OutputAmtgroupItemVo outputAmtgroupItemVo ) throws Exception { 
		int iResult = outputAmtgroupItemService.deleteOutputAmtgroupItem(outputAmtgroupItemVo);
		return outputAmtgroupItemVo;
	}

	// Merge List

	@RequestMapping(value="/mergeoutputAmtgroupItemID",method= {RequestMethod.POST})
	public OutputAmtgroupItemVo MergeOutputAmtgroupItemList(@RequestBody OutputAmtgroupItemSVo outputAmtgroupItemSVo ) { 
		int iResult = 0;
		for(OutputAmtgroupItemVo vo : outputAmtgroupItemSVo.getOutputAmtgroupItemListVo()) {
			iResult = iResult + outputAmtgroupItemService.mergeOutputAmtgroupItem(vo);
		}
		OutputAmtgroupItemVo outputAmtgroupItemVo = new OutputAmtgroupItemVo();
		BeanUtils.copyProperties(outputAmtgroupItemSVo, outputAmtgroupItemVo);
		return outputAmtgroupItemVo;
	}
}