package com.mibbeun.fml.Controller;
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
import com.mibbeun.fml.Service.TopFamilyService;
import com.mibbeun.fml.Vo.TopFamilyVo;
import com.mibbeun.fml.Vo.TopFamilySVo;

@RestController
@RequestMapping("/")

public class TopFamilyController {  
	@Autowired
	TopFamilyService topFamilyService;

	// One Select
	@RequestMapping(value="/topFamilyOneID",method= {RequestMethod.POST})
	public TopFamilyVo SelectTopFamilyOne(@RequestBody TopFamilyVo topFamilyVo ) { 
		TopFamilyVo inputTopFamilyVo = new TopFamilyVo();
		BeanUtils.copyProperties(topFamilyVo, inputTopFamilyVo);
		TopFamilyVo oneTopFamilyVo = topFamilyService.topFamilyOneData(inputTopFamilyVo);
		return oneTopFamilyVo;
	}

	// Select List

	@RequestMapping(value="/topFamilyListID",method= {RequestMethod.POST})
	public TopFamilySVo SelectTopFamilyList(@RequestBody TopFamilyVo topFamilyVo ) { 
		TopFamilyVo inputTopFamilyVo =  new TopFamilyVo();
		BeanUtils.copyProperties(topFamilyVo, inputTopFamilyVo);
		List<TopFamilyVo> topFamilyListVo = topFamilyService.topFamilyListData(inputTopFamilyVo);
		TopFamilySVo topFamilySVo =  new TopFamilySVo();
		topFamilySVo.setTopFamilyListVo(topFamilyListVo);
		return topFamilySVo;
	}

	// insert
	@RequestMapping(value="/insertTopFamilyID",method= {RequestMethod.POST})
	public TopFamilyVo InsertTopFamily(@RequestBody TopFamilyVo topFamilyVo ) throws Exception { 
		int iResult = topFamilyService.insertTopFamily(topFamilyVo);
		return topFamilyVo;
	}

	// update
	@RequestMapping(value="/updateTopFamilyID",method= {RequestMethod.POST})
	public TopFamilyVo updateTopFamily(@RequestBody TopFamilyVo topFamilyVo ) throws Exception { 
		int iResult = topFamilyService.updateTopFamily(topFamilyVo);
		return topFamilyVo;
	}

	// delete
	@RequestMapping(value="/deleteTopFamilyID",method= {RequestMethod.POST})
	public TopFamilyVo DeleteTopFamily(@RequestBody TopFamilyVo topFamilyVo ) throws Exception { 
		int iResult = topFamilyService.deleteTopFamily(topFamilyVo);
		return topFamilyVo;
	}

	// Merge List

	@RequestMapping(value="/mergetopFamilyID",method= {RequestMethod.POST})
	public TopFamilyVo MergeTopFamilyList(@RequestBody TopFamilySVo topFamilySVo ) { 
		int iResult = 0;
		for(TopFamilyVo vo : topFamilySVo.getTopFamilyListVo()) {
			iResult = iResult + topFamilyService.mergeTopFamily(vo);
		}
		TopFamilyVo topFamilyVo = new TopFamilyVo();
		BeanUtils.copyProperties(topFamilySVo, topFamilyVo);
		return topFamilyVo;
	}
}
