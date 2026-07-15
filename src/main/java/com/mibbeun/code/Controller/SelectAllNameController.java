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
import com.mibbeun.code.Service.SelectAllNameService;
import com.mibbeun.code.Vo.SelectAllNameVo;
import com.mibbeun.code.Vo.SelectAllNameSVo;

@RestController
@RequestMapping("/")

public class SelectAllNameController {  
	@Autowired
	SelectAllNameService selectAllNameService;

	// One Select
	@RequestMapping(value="/selectAllNameOneID",method= {RequestMethod.POST})
	public SelectAllNameVo SelectSelectAllNameOne(@RequestBody SelectAllNameVo selectAllNameVo ) { 
		SelectAllNameVo inputSelectAllNameVo = new SelectAllNameVo();
		BeanUtils.copyProperties(selectAllNameVo, inputSelectAllNameVo);
		SelectAllNameVo oneSelectAllNameVo = selectAllNameService.selectAllNameOneData(inputSelectAllNameVo);
		return oneSelectAllNameVo;
	}

	// Select List
	@RequestMapping(value="/selectAllNameListID",method= {RequestMethod.POST})
	public SelectAllNameSVo SelectSelectAllNameList(@RequestBody SelectAllNameSVo selectAllNameSVo ) { 
		SelectAllNameVo inputSelectAllNameVo =  new SelectAllNameVo();
		BeanUtils.copyProperties(selectAllNameSVo, inputSelectAllNameVo);
		List<SelectAllNameVo> selectAllNameListVo = selectAllNameService.selectAllNameListData(inputSelectAllNameVo);
		SelectAllNameSVo outSelectAllNameSVo =  new SelectAllNameSVo();
		outSelectAllNameSVo.setSelectAllNameListVo(selectAllNameListVo);
		return outSelectAllNameSVo;
	}
}
