package com.mibbeun.login.Controller;
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
import com.mibbeun.login.Service.ProgListService;
import com.mibbeun.login.Vo.ProgListVo;
import com.mibbeun.login.Vo.ProgListSVo;

@RestController
@RequestMapping("/")

public class ProgListController {  
	@Autowired
	ProgListService progListService;

	// One Select
	@RequestMapping(value="/progListOneID",method= {RequestMethod.POST})
	public ProgListVo SelectProgListOne(@RequestBody ProgListVo progListVo ) { 
		ProgListVo inputProgListVo = new ProgListVo();
		BeanUtils.copyProperties(progListVo, inputProgListVo);
		ProgListVo oneProgListVo = progListService.progListOneData(inputProgListVo);
		return oneProgListVo;
	}

	// Select List
	@RequestMapping(value="/progListListID",method= {RequestMethod.POST})
	public ProgListSVo SelectProgListList(@RequestBody ProgListVo progListVo ) { 
		ProgListVo inputProgListVo =  new ProgListVo();
		BeanUtils.copyProperties(progListVo, inputProgListVo);
		List<ProgListVo> progListListVo = progListService.progListListData(inputProgListVo);
		ProgListSVo outProgListSVo =  new ProgListSVo();
		outProgListSVo.setProgListListVo(progListListVo);

		return outProgListSVo;
	}
}
