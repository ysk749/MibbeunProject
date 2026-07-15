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
import com.mibbeun.amt.Service.MonthSumService;
import com.mibbeun.amt.Vo.MonthSumVo;
import com.mibbeun.amt.Vo.MonthStrSumVo;
import com.mibbeun.amt.Vo.MonthSumSVo;

@RestController
@RequestMapping("/")

public class MonthSumController {  
	@Autowired
	MonthSumService monthSumService;


	// Select List
	@RequestMapping(value="/monthInSumListID",method= {RequestMethod.POST})
	public MonthSumSVo SelectInMonthSumList(@RequestBody MonthStrSumVo monthStrSumVo ) { 
		List<MonthSumVo> monthSumListVo = monthSumService.inMonthSumListData(monthStrSumVo);
		MonthSumSVo outMonthSumSVo =  new MonthSumSVo();
		outMonthSumSVo.setMonthSumListVo(monthSumListVo);
		return outMonthSumSVo;
	}
	
	// Select List
	@RequestMapping(value="/monthOutSumListID",method= {RequestMethod.POST})
	public MonthSumSVo SelectOutMonthSumList(@RequestBody MonthStrSumVo monthStrSumVo ) { 
		List<MonthSumVo> monthSumListVo = monthSumService.outMonthSumListData(monthStrSumVo);
		MonthSumSVo outMonthSumSVo =  new MonthSumSVo();
		outMonthSumSVo.setMonthSumListVo(monthSumListVo);
		return outMonthSumSVo;
	}
	
	// Select List
	@RequestMapping(value="/monthInTotSumListID",method= {RequestMethod.POST})
	public MonthSumSVo SelectInMonthTotSumList(@RequestBody MonthStrSumVo monthStrSumVo ) { 
		List<MonthSumVo> monthSumListVo = monthSumService.inMonthTotSumListData(monthStrSumVo);
		MonthSumSVo outMonthSumSVo =  new MonthSumSVo();
		outMonthSumSVo.setMonthSumListVo(monthSumListVo);
		return outMonthSumSVo;
	}
	
	// Select List
	@RequestMapping(value="/monthOutTotSumListID",method= {RequestMethod.POST})
	public MonthSumSVo SelectOutMonthTotSumList(@RequestBody MonthStrSumVo monthStrSumVo ) { 
		List<MonthSumVo> monthSumListVo = monthSumService.outMonthTotSumListData(monthStrSumVo);
		MonthSumSVo outMonthSumSVo =  new MonthSumSVo();
		outMonthSumSVo.setMonthSumListVo(monthSumListVo);
		return outMonthSumSVo;
	}	
}
