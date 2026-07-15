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
import com.mibbeun.amt.Service.SumOutputDataService;
import com.mibbeun.amt.Vo.SumOutputDataVo;
import com.mibbeun.amt.Vo.SumOutputDataSVo;
import com.mibbeun.amt.Vo.BaseDataVo;

@RestController
@RequestMapping("/")

public class SumOutputDataController {  
	@Autowired
	SumOutputDataService sumOutputDataService;

	// One Select
	@RequestMapping(value="/sumOutputDataOneID",method= {RequestMethod.POST})
	public SumOutputDataVo SelectSumOutputDataOne(@RequestBody BaseDataVo baseDataVo ) { 
		SumOutputDataVo oneSumOutputDataVo = sumOutputDataService.sumOutputDataOneData(baseDataVo);
		return oneSumOutputDataVo;
	}

	// Select List
	@RequestMapping(value="/sumOutputDataListID",method= {RequestMethod.POST})
	public SumOutputDataSVo SelectSumOutputDataList(@RequestBody BaseDataVo baseDataVo ) { 
		List<SumOutputDataVo> sumOutputDataListVo = sumOutputDataService.sumOutputDataListData(baseDataVo);
		SumOutputDataSVo outSumOutputDataSVo =  new SumOutputDataSVo();
		outSumOutputDataSVo.setSumOutputDataListVo(sumOutputDataListVo);
		return outSumOutputDataSVo;
	}
}
