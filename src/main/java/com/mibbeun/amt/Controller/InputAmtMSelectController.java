package com.mibbeun.amt.Controller;
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
import com.mibbeun.amt.Service.InputAmtMSelectService;
import com.mibbeun.amt.Vo.InputAmtMSelectVo;
import com.mibbeun.amt.Vo.InputAmtMSelectSVo;

@RestController
@RequestMapping("/")

public class InputAmtMSelectController {  
	@Autowired
	InputAmtMSelectService inputAmtMSelectService;

	// One Select
	@RequestMapping(value="/inputAmtMSelectOneID",method= {RequestMethod.POST})
	public InputAmtMSelectVo SelectInputAmtMSelectOne(@RequestBody InputAmtMSelectVo inputAmtMSelectVo ) { 
		InputAmtMSelectVo inputInputAmtMSelectVo = new InputAmtMSelectVo();
		BeanUtils.copyProperties(inputAmtMSelectVo, inputInputAmtMSelectVo);
		InputAmtMSelectVo oneInputAmtMSelectVo = inputAmtMSelectService.inputAmtMSelectOneData(inputInputAmtMSelectVo);
		return oneInputAmtMSelectVo;
	}

	// Select List
	@RequestMapping(value="/inputAmtMSelectListID",method= {RequestMethod.POST})
	public InputAmtMSelectSVo SelectInputAmtMSelectList(@RequestBody InputAmtMSelectVo inputAmtMSelectVo ) { 

		List<InputAmtMSelectVo> inputAmtMSelectListVo = inputAmtMSelectService.inputAmtMSelectListData(inputAmtMSelectVo);
		InputAmtMSelectSVo outInputAmtMSelectSVo =  new InputAmtMSelectSVo();
		outInputAmtMSelectSVo.setInputAmtMSelectListVo(inputAmtMSelectListVo);
		return outInputAmtMSelectSVo;
	}
	
	// One Select
	@RequestMapping(value="/inputSunAmtMSelectOneID",method= {RequestMethod.POST})
	public InputAmtMSelectVo SelectInputSunAmtMSelectOne(@RequestBody InputAmtMSelectVo inputAmtMSelectVo ) { 
		InputAmtMSelectVo inputInputAmtMSelectVo = new InputAmtMSelectVo();
		BeanUtils.copyProperties(inputAmtMSelectVo, inputInputAmtMSelectVo);
		InputAmtMSelectVo oneInputAmtMSelectVo = inputAmtMSelectService.inputSunAmtMSelectOneData(inputInputAmtMSelectVo);
		return oneInputAmtMSelectVo;
	}

	// Select List
	@RequestMapping(value="/inputSunAmtMSelectListID",method= {RequestMethod.POST})
	public InputAmtMSelectSVo SelectInputSunAmtMSelectList(@RequestBody InputAmtMSelectVo inputAmtMSelectVo ) { 

		List<InputAmtMSelectVo> inputAmtMSelectListVo = inputAmtMSelectService.inputSunAmtMSelectListData(inputAmtMSelectVo);
		InputAmtMSelectSVo outInputAmtMSelectSVo =  new InputAmtMSelectSVo();
		outInputAmtMSelectSVo.setInputAmtMSelectListVo(inputAmtMSelectListVo);
		return outInputAmtMSelectSVo;
	}	
}
