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
import com.mibbeun.amt.Service.SumInputDataService;
import com.mibbeun.amt.Vo.SumInputDataVo;
import com.mibbeun.amt.Vo.SumInputDataSVo;
import com.mibbeun.amt.Vo.BaseDataVo;


@RestController
@RequestMapping("/")

public class SumInputDataController {  
	@Autowired
	SumInputDataService sumInputDataService;

	// One Select
	@RequestMapping(value="/sumInputDataOneID",method= {RequestMethod.POST})
	public SumInputDataVo SelectSumInputDataOne(@RequestBody BaseDataVo baseDataVo ) { 
		SumInputDataVo oneSumInputDataVo = sumInputDataService.sumInputDataOneData(baseDataVo);
		return oneSumInputDataVo;
	}

	// Select List
	@RequestMapping(value="/sumInputDataListID",method= {RequestMethod.POST})
	public SumInputDataSVo SelectSumInputDataList(@RequestBody BaseDataVo baseDataVo ) { 
		List<SumInputDataVo> sumInputDataListVo = sumInputDataService.sumInputDataListData(baseDataVo);
		SumInputDataSVo outSumInputDataSVo =  new SumInputDataSVo();
		outSumInputDataSVo.setSumInputDataListVo(sumInputDataListVo);
		return outSumInputDataSVo;
	}
}
