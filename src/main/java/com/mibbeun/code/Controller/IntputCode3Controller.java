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
import com.mibbeun.code.Service.IntputCode3Service;
import com.mibbeun.code.Vo.IntputCode3Vo;
import com.mibbeun.code.Vo.IntputCode3SVo;

@RestController
@RequestMapping("/")

public class IntputCode3Controller {  
	@Autowired
	IntputCode3Service intputCode3Service;
	@Autowired
	CodeSeqNoService codeSeqNoService;
	
	// One Select
	@RequestMapping(value="/intputCode3OneID",method= {RequestMethod.POST})
	public IntputCode3Vo SelectIntputCode3One(@RequestBody IntputCode3Vo intputCode3Vo ) { 
		IntputCode3Vo inputIntputCode3Vo = new IntputCode3Vo();
		BeanUtils.copyProperties(intputCode3Vo, inputIntputCode3Vo);
		IntputCode3Vo oneIntputCode3Vo = intputCode3Service.intputCode3OneData(inputIntputCode3Vo);
		return oneIntputCode3Vo;
	}

	// Select List

	@RequestMapping(value="/intputCode3ListID",method= {RequestMethod.POST})
	public IntputCode3SVo SelectIntputCode3List(@RequestBody IntputCode3Vo intputCode3Vo ) { 
		IntputCode3Vo inputIntputCode3Vo =  new IntputCode3Vo();
		BeanUtils.copyProperties(intputCode3Vo, inputIntputCode3Vo);
		List<IntputCode3Vo> intputCode3ListVo = intputCode3Service.intputCode3ListData(inputIntputCode3Vo);
		IntputCode3SVo intputCode3SVo =  new IntputCode3SVo();
		intputCode3SVo.setIntputCode3ListVo(intputCode3ListVo);
		return intputCode3SVo;
	}

	// insert
	@RequestMapping(value="/insertIntputCode3ID",method= {RequestMethod.POST})
	public IntputCode3Vo InsertIntputCode3(@RequestBody IntputCode3Vo intputCode3Vo ) throws Exception { 
		String clssCode = "수입";  
		String divisCode = "목코드"; 
		String codeGb = intputCode3Vo.getCodeGb();
		
		int iNumber = codeSeqNoService.getCodeSeqNodata(clssCode, divisCode, codeGb);
		intputCode3Vo.setCode3(iNumber);
				
		int iResult = intputCode3Service.insertIntputCode3(intputCode3Vo);
		return intputCode3Vo;
	}

	// update
	@RequestMapping(value="/updateIntputCode3ID",method= {RequestMethod.POST})
	public IntputCode3Vo updateIntputCode3(@RequestBody IntputCode3Vo intputCode3Vo ) throws Exception { 
		int iResult = intputCode3Service.updateIntputCode3(intputCode3Vo);
		return intputCode3Vo;
	}
	
	// update
	@RequestMapping(value="/deleteIntputCode3ID",method= {RequestMethod.POST})
	public IntputCode3Vo DeleteIntputCode3(@RequestBody IntputCode3Vo intputCode3Vo ) throws Exception { 
		int iResult = intputCode3Service.deleteIntputCode3(intputCode3Vo);
		return intputCode3Vo;
	}
	
	// Merge List

	@RequestMapping(value="/mergeintputCode3ID",method= {RequestMethod.POST})
	public IntputCode3Vo MergeIntputCode3List(@RequestBody IntputCode3SVo intputCode3SVo ) { 
		int iResult = 0;
		for(IntputCode3Vo vo : intputCode3SVo.getIntputCode3ListVo()) {
			iResult = iResult + intputCode3Service.mergeIntputCode3(vo);
		}
		IntputCode3Vo intputCode3Vo = new IntputCode3Vo();
		BeanUtils.copyProperties(intputCode3SVo, intputCode3Vo);
		return intputCode3Vo;
	}
}
