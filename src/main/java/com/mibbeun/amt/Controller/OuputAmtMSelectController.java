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
import com.mibbeun.amt.Service.OuputAmtMSelectService;
import com.mibbeun.amt.Vo.OuputAmtMSelectVo;
import com.mibbeun.amt.Vo.OuputAmtMSelectSVo;

@RestController
@RequestMapping("/")

public class OuputAmtMSelectController {  
	@Autowired
	OuputAmtMSelectService ouputAmtMSelectService;

	// One Select
	@RequestMapping(value="/ouputAmtMSelectOneID",method= {RequestMethod.POST})
	public OuputAmtMSelectVo SelectOuputAmtMSelectOne(@RequestBody OuputAmtMSelectVo ouputAmtMSelectVo ) { 
		OuputAmtMSelectVo inputOuputAmtMSelectVo = new OuputAmtMSelectVo();
		BeanUtils.copyProperties(ouputAmtMSelectVo, inputOuputAmtMSelectVo);
		OuputAmtMSelectVo oneOuputAmtMSelectVo = ouputAmtMSelectService.ouputAmtMSelectOneData(inputOuputAmtMSelectVo);
		return oneOuputAmtMSelectVo;
	}

	// Select List
	@RequestMapping(value="/ouputAmtMSelectListID",method= {RequestMethod.POST})
	public OuputAmtMSelectSVo SelectOuputAmtMSelectList(@RequestBody OuputAmtMSelectVo ouputAmtMSelectVo ) { 
		List<OuputAmtMSelectVo> ouputAmtMSelectListVo = ouputAmtMSelectService.ouputAmtMSelectListData(ouputAmtMSelectVo);
		OuputAmtMSelectSVo outOuputAmtMSelectSVo =  new OuputAmtMSelectSVo();
		outOuputAmtMSelectSVo.setOuputAmtMSelectListVo(ouputAmtMSelectListVo);
		return outOuputAmtMSelectSVo;
	}
}
