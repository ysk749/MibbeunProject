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
import com.mibbeun.amt.Service.InputFamilySumService;
import com.mibbeun.amt.Vo.InputFamilySumVo;
import com.mibbeun.amt.Vo.InputFamilySumSVo;

@RestController
@RequestMapping("/")

public class InputFamilySumController {  
	@Autowired
	InputFamilySumService inputFamilySumService;

	// Select List
	@RequestMapping(value="/inputFamilySumList1ID",method= {RequestMethod.POST})
	public InputFamilySumSVo SelectInputFamilySumList1(@RequestBody InputFamilySumVo inputFamilySumVo ) { 
		List<InputFamilySumVo> inputFamilySumListVo = inputFamilySumService.inputFamilySumListData1(inputFamilySumVo);
		InputFamilySumSVo outInputFamilySumSVo =  new InputFamilySumSVo();
		outInputFamilySumSVo.setInputFamilySumListVo(inputFamilySumListVo);
		return outInputFamilySumSVo;
	}

	@RequestMapping(value="/inputFamilySumList2ID",method= {RequestMethod.POST})
	public InputFamilySumSVo SelectInputFamilySumList2(@RequestBody InputFamilySumVo inputFamilySumVo ) { 
		List<InputFamilySumVo> inputFamilySumListVo = inputFamilySumService.inputFamilySumListData2(inputFamilySumVo);
		InputFamilySumSVo outInputFamilySumSVo =  new InputFamilySumSVo();
		outInputFamilySumSVo.setInputFamilySumListVo(inputFamilySumListVo);
		return outInputFamilySumSVo;
	}

	@RequestMapping(value="/inputFamilySumList3ID",method= {RequestMethod.POST})
	public InputFamilySumSVo SelectInputFamilySum3List(@RequestBody InputFamilySumVo inputFamilySumVo ) { 
		List<InputFamilySumVo> inputFamilySumListVo = inputFamilySumService.inputFamilySumListData3(inputFamilySumVo);
		InputFamilySumSVo outInputFamilySumSVo =  new InputFamilySumSVo();
		outInputFamilySumSVo.setInputFamilySumListVo(inputFamilySumListVo);
		return outInputFamilySumSVo;
	}

	@RequestMapping(value="/inputFamilySumList4ID",method= {RequestMethod.POST})
	public InputFamilySumSVo SelectInputFamilySumList4(@RequestBody InputFamilySumVo inputFamilySumVo ) { 
		List<InputFamilySumVo> inputFamilySumListVo = inputFamilySumService.inputFamilySumListData4(inputFamilySumVo);
		InputFamilySumSVo outInputFamilySumSVo =  new InputFamilySumSVo();
		outInputFamilySumSVo.setInputFamilySumListVo(inputFamilySumListVo);
		return outInputFamilySumSVo;
	}
	
}
