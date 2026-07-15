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
import com.mibbeun.amt.Service.SumDataService;
import com.mibbeun.amt.Vo.SumDataVo;
import com.mibbeun.amt.Vo.BaseDataVo;
import com.mibbeun.amt.Vo.SumDataSVo;

@RestController
@RequestMapping("/")

public class SumDataController {  
	@Autowired
	SumDataService sumDataService;

	// One Select
	@RequestMapping(value="/sumDataOneID",method= {RequestMethod.POST})
	public SumDataSVo SelectSumDataOne(@RequestBody BaseDataVo baseDataVo ) { 
		SumDataVo oneSumDataVo = sumDataService.sumDataOneData(baseDataVo);
		SumDataSVo outSumDataSVo =  new SumDataSVo();
		outSumDataSVo.setSumDataVo(oneSumDataVo);
		return outSumDataSVo;
	}

	// Select List
	@RequestMapping(value="/sumDataListID",method= {RequestMethod.POST})
	public SumDataSVo SelectSumDataList(@RequestBody BaseDataVo baseDataVo ) { 
		List<SumDataVo> sumDataListVo = sumDataService.sumDataListData(baseDataVo);
		SumDataSVo outSumDataSVo =  new SumDataSVo();
		outSumDataSVo.setSumDataListVo(sumDataListVo);
		return outSumDataSVo;
	}
}
