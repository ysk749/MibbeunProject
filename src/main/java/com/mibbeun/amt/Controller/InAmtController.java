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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibbeun.amt.Service.InAmtService;
import com.mibbeun.amt.Vo.InAmtVo;
import com.mibbeun.amt.Vo.InAmtSVo;

@RestController
@RequestMapping("/")

public class InAmtController {  
	@Autowired
	InAmtService inAmtService;

	// One Select
	@RequestMapping(value="/inAmtOneID",method= {RequestMethod.POST})
	public InAmtVo SelectInAmtOne(@RequestBody InAmtVo inAmtVo ) { 
		InAmtVo inputInAmtVo = new InAmtVo();
		BeanUtils.copyProperties(inAmtVo, inputInAmtVo);
		InAmtVo oneInAmtVo = inAmtService.inAmtOneData(inputInAmtVo);
		return oneInAmtVo;
	}

	// Select List

	@RequestMapping(value="/inAmtListID",method={RequestMethod.POST})
	public InAmtSVo SelectInAmtList(@RequestBody InAmtVo inAmtVo ) { 
		InAmtVo inputInAmtVo =  new InAmtVo();
		BeanUtils.copyProperties(inAmtVo, inputInAmtVo);
		List<InAmtVo> inAmtListVo = inAmtService.inAmtListData(inputInAmtVo);
		InAmtSVo inAmtSVo =  new InAmtSVo();
		inAmtSVo.setInAmtListVo(inAmtListVo);
		return inAmtSVo;
	}

	// insert
	@RequestMapping(value="/insertInAmtID",method={RequestMethod.POST})
	public InAmtVo InsertInAmt(@RequestBody InAmtVo inAmtVo ) throws Exception { 
		int iResult = inAmtService.insertInAmt(inAmtVo);
		return inAmtVo;
	}
	
	// insert
	@RequestMapping(value="/insertInAmtID_B",method={RequestMethod.POST})
	public InAmtVo InsertInAmt_B(@RequestBody byte[] Adata ) throws Exception { 
		ObjectMapper objectMapper = new ObjectMapper();
		//파라미터Map에서?DTO에?들어있지?않는?변수가?있어도?무시함.
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		InAmtVo inAmtVo = objectMapper.readValue(Adata, InAmtVo.class);
		int iResult = inAmtService.insertInAmt(inAmtVo);
		return inAmtVo;
	}
	
	
	// update
	@RequestMapping(value="/updateInAmtID",method= {RequestMethod.POST})
	public InAmtVo updateInAmt(@RequestBody InAmtVo inAmtVo ) throws Exception { 
		int iResult = inAmtService.updateInAmt(inAmtVo);
		return inAmtVo;
	}
	
	// delete
	@RequestMapping(value="/deleteInAmtID",method= {RequestMethod.POST})
	public InAmtVo deleteInAmt(@RequestBody InAmtVo inAmtVo ) throws Exception { 
		int iResult = inAmtService.deleteInAmt(inAmtVo);
		return inAmtVo;
	}	
	
	@RequestMapping(value="/sunToInAmtInsertID",method= {RequestMethod.POST})
	public InAmtVo SunToInAmtInsert(@RequestBody InAmtVo inAmtVo ) throws Exception { 
		int iResult = inAmtService.sunToInAmtInsert(inAmtVo);
		return inAmtVo;
	}		
	

	// Merge List

	@RequestMapping(value="/mergeinAmtID",method= {RequestMethod.POST})
	public InAmtVo MergeInAmtList(@RequestBody InAmtSVo inAmtSVo ) { 
		int iResult = 0;
		for(InAmtVo vo : inAmtSVo.getInAmtListVo()) {
			iResult = iResult + inAmtService.mergeInAmt(vo);
		}
		InAmtVo inAmtVo = new InAmtVo();
		BeanUtils.copyProperties(inAmtSVo, inAmtVo);
		return inAmtVo;
	}
}
