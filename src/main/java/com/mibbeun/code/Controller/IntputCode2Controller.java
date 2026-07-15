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
import com.mibbeun.code.Service.IntputCode2Service;
import com.mibbeun.code.Vo.IntputCode2Vo;
import com.mibbeun.code.Vo.IntputCode2SVo;

@RestController
@RequestMapping("/")

public class IntputCode2Controller {  
	@Autowired
	IntputCode2Service intputCode2Service;
	@Autowired
	CodeSeqNoService codeSeqNoService;
	
	

	// One Select
	@RequestMapping(value="/intputCode2OneID",method= {RequestMethod.POST})
	public IntputCode2Vo SelectIntputCode2One(@RequestBody IntputCode2Vo intputCode2Vo ) { 
		IntputCode2Vo inputIntputCode2Vo = new IntputCode2Vo();
		BeanUtils.copyProperties(intputCode2Vo, inputIntputCode2Vo);
		IntputCode2Vo oneIntputCode2Vo = intputCode2Service.intputCode2OneData(inputIntputCode2Vo);
		return oneIntputCode2Vo;
	}

	// Select List

	@RequestMapping(value="/intputCode2ListID",method= {RequestMethod.POST})
	public IntputCode2SVo SelectIntputCode2List(@RequestBody IntputCode2Vo intputCode2Vo ) { 
		IntputCode2Vo inputIntputCode2Vo =  new IntputCode2Vo();
		BeanUtils.copyProperties(intputCode2Vo, inputIntputCode2Vo);
		List<IntputCode2Vo> intputCode2ListVo = intputCode2Service.intputCode2ListData(inputIntputCode2Vo);
		IntputCode2SVo intputCode2SVo =  new IntputCode2SVo();
		intputCode2SVo.setIntputCode2ListVo(intputCode2ListVo);
		return intputCode2SVo;
	}

	// insert
	@RequestMapping(value="/insertIntputCode2ID",method= {RequestMethod.POST})
	public IntputCode2Vo InsertIntputCode2(@RequestBody IntputCode2Vo intputCode2Vo ) throws Exception { 
		String clssCode = "수입";  
		String divisCode = "항코드"; 
		String codeGb = intputCode2Vo.getCodeGb();
		
		int iNumber = codeSeqNoService.getCodeSeqNodata(clssCode, divisCode, codeGb);
		intputCode2Vo.setCode2(iNumber);
		
		int iResult = intputCode2Service.insertIntputCode2(intputCode2Vo);
		return intputCode2Vo;
	}

	// update
	@RequestMapping(value="/updateIntputCode2ID",method= {RequestMethod.POST})
	public IntputCode2Vo updateIntputCode2(@RequestBody IntputCode2Vo intputCode2Vo ) throws Exception { 
		int iResult = intputCode2Service.updateIntputCode2(intputCode2Vo);
		return intputCode2Vo;
	}
	
	// update
	@RequestMapping(value="/deleteIntputCode2ID",method= {RequestMethod.POST})
	public IntputCode2Vo deleteIntputCode2(@RequestBody IntputCode2Vo intputCode2Vo ) throws Exception { 
		int iResult = intputCode2Service.deleteIntputCode2(intputCode2Vo);
		return intputCode2Vo;
	}


	// Merge List

	@RequestMapping(value="/mergeintputCode2ID",method= {RequestMethod.POST})
	public IntputCode2Vo MergeIntputCode2List(@RequestBody IntputCode2SVo intputCode2SVo ) { 
		int iResult = 0;
		for(IntputCode2Vo vo : intputCode2SVo.getIntputCode2ListVo()) {
			iResult = iResult + intputCode2Service.mergeIntputCode2(vo);
		}
		IntputCode2Vo intputCode2Vo = new IntputCode2Vo();
		BeanUtils.copyProperties(intputCode2SVo, intputCode2Vo);
		return intputCode2Vo;
	}
}
