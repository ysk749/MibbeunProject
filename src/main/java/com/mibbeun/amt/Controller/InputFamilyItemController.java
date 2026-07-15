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
import com.mibbeun.amt.Service.InputFamilyItemService;
import com.mibbeun.amt.Vo.InputFamilyItemVo;
import com.mibbeun.amt.Vo.InputFamilyItemSVo;

@RestController
@RequestMapping("/")

public class InputFamilyItemController {  
	@Autowired
	InputFamilyItemService inputFamilyItemService;

	// Select List
	@RequestMapping(value="/inputFamilyItemList1ID",method= {RequestMethod.POST})
	public InputFamilyItemSVo SelectInputFamilyItemList1(@RequestBody InputFamilyItemVo inputFamilyItemVo ) { 
		List<InputFamilyItemVo> inputFamilyItemListVo = inputFamilyItemService.inputFamilyItemListData1(inputFamilyItemVo);
		InputFamilyItemSVo outInputFamilyItemSVo =  new InputFamilyItemSVo();
		outInputFamilyItemSVo.setInputFamilyItemListVo(inputFamilyItemListVo);
		return outInputFamilyItemSVo;
	}
	
	@RequestMapping(value="/inputFamilyItemList2ID",method= {RequestMethod.POST})
	public InputFamilyItemSVo SelectInputFamilyItemList2(@RequestBody InputFamilyItemVo inputFamilyItemVo ) { 
		List<InputFamilyItemVo> inputFamilyItemListVo = inputFamilyItemService.inputFamilyItemListData2(inputFamilyItemVo);
		InputFamilyItemSVo outInputFamilyItemSVo =  new InputFamilyItemSVo();
		outInputFamilyItemSVo.setInputFamilyItemListVo(inputFamilyItemListVo);
		return outInputFamilyItemSVo;
	}
		
	
}
