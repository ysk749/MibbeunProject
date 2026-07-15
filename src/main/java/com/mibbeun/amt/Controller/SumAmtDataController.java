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
import com.mibbeun.amt.Service.SumAmtDataService;
import com.mibbeun.amt.Vo.SumAmtDataVo;
import com.mibbeun.amt.Vo.SumAmtDataSVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@RestController
@RequestMapping("/")

public class SumAmtDataController {  
	@Autowired
	SumAmtDataService sumAmtDataService;

	// One Select
	@RequestMapping(value="/sumAmtDataOneID",method= {RequestMethod.POST})
	public SumAmtDataVo SelectSumAmtDataOne(@RequestBody BaseDataVo baseDataVo ) { 

		SumAmtDataVo oneSumAmtDataVo = sumAmtDataService.sumAmtDataOneData(baseDataVo);
		return oneSumAmtDataVo;
	}

	// Select List
	@RequestMapping(value="/sumAmtDataListID",method= {RequestMethod.POST})
	public SumAmtDataSVo SelectSumAmtDataList(@RequestBody BaseDataVo baseDataVo ) { 

		List<SumAmtDataVo> sumAmtDataListVo = sumAmtDataService.sumAmtDataListData(baseDataVo);
		SumAmtDataSVo outSumAmtDataSVo =  new SumAmtDataSVo();
		outSumAmtDataSVo.setSumAmtDataListVo(sumAmtDataListVo);
		return outSumAmtDataSVo;
	}
}
