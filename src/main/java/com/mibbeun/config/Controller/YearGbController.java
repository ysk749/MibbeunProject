package com.mibbeun.config.Controller;
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
import com.mibbeun.config.Service.YearGbService;
import com.mibbeun.config.Vo.YearGbVo;
import com.mibbeun.config.Vo.YearGbSVo;

@RestController
@RequestMapping("/")

public class YearGbController {  
	@Autowired
	YearGbService yearGbService;

	// One Select
	@RequestMapping(value="/yearGbOneID",method= {RequestMethod.POST})
	public YearGbVo SelectYearGbOne(@RequestBody YearGbVo yearGbVo ) { 
		YearGbVo inputYearGbVo = new YearGbVo();
		BeanUtils.copyProperties(yearGbVo, inputYearGbVo);
		YearGbVo oneYearGbVo = yearGbService.yearGbOneData(inputYearGbVo);
		return oneYearGbVo;
	}

	// Select List

	@RequestMapping(value="/yearGbListID",method= {RequestMethod.POST})
	public YearGbSVo SelectYearGbList(@RequestBody YearGbVo yearGbVo ) { 
		YearGbVo inputYearGbVo =  new YearGbVo();
		BeanUtils.copyProperties(yearGbVo, inputYearGbVo);
		List<YearGbVo> yearGbListVo = yearGbService.yearGbListData(inputYearGbVo);
		YearGbSVo yearGbSVo =  new YearGbSVo();
		yearGbSVo.setYearGbListVo(yearGbListVo);
		return yearGbSVo;
	}

	// insert
	@RequestMapping(value="/insertYearGbID",method= {RequestMethod.POST})
	public YearGbVo InsertYearGb(@RequestBody YearGbVo yearGbVo ) throws Exception { 
		int iResult = yearGbService.insertYearGb(yearGbVo);
		return yearGbVo;
	}

	// update
	@RequestMapping(value="/updateYearGbID",method= {RequestMethod.POST})
	public YearGbVo updateYearGb(@RequestBody YearGbVo yearGbVo ) throws Exception { 
		int iResult = yearGbService.updateYearGb(yearGbVo);
		return yearGbVo;
	}

	// Merge List

	@RequestMapping(value="/mergeyearGbID",method= {RequestMethod.POST})
	public YearGbVo MergeYearGbList(@RequestBody YearGbSVo yearGbSVo ) { 
		int iResult = 0;
		for(YearGbVo vo : yearGbSVo.getYearGbListVo()) {
			iResult = iResult + yearGbService.mergeYearGb(vo);
		}
		YearGbVo yearGbVo = new YearGbVo();
		BeanUtils.copyProperties(yearGbSVo, yearGbVo);
		return yearGbVo;
	}
}
