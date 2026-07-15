package com.mibbeun.code.Controller;
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
import com.mibbeun.code.Service.PmRelationService;
import com.mibbeun.code.Vo.PmRelationVo;
import com.mibbeun.code.Vo.PmRelationSVo;

@RestController
@RequestMapping("/")

public class PmRelationController {  
	@Autowired
	PmRelationService pmRelationService;

	// One Select
	@RequestMapping(value="/pmRelationOneID",method= {RequestMethod.POST})
	public PmRelationVo SelectPmRelationOne(@RequestBody PmRelationVo pmRelationVo ) { 
		PmRelationVo inputPmRelationVo = new PmRelationVo();
		BeanUtils.copyProperties(pmRelationVo, inputPmRelationVo);
		PmRelationVo onePmRelationVo = pmRelationService.pmRelationOneData(inputPmRelationVo);
		return onePmRelationVo;
	}

	// Select List

	@RequestMapping(value="/pmRelationListID",method= {RequestMethod.POST})
	public PmRelationSVo SelectPmRelationList(@RequestBody PmRelationVo pmRelationVo ) { 
		PmRelationVo inputPmRelationVo =  new PmRelationVo();
		BeanUtils.copyProperties(pmRelationVo, inputPmRelationVo);
		List<PmRelationVo> pmRelationListVo = pmRelationService.pmRelationListData(inputPmRelationVo);
		PmRelationSVo pmRelationSVo =  new PmRelationSVo();
		pmRelationSVo.setPmRelationListVo(pmRelationListVo);
		return pmRelationSVo;
	}

	// insert
	@RequestMapping(value="/insertPmRelationID",method= {RequestMethod.POST})
	public PmRelationVo InsertPmRelation(@RequestBody PmRelationVo pmRelationVo ) throws Exception { 
		int iResult = pmRelationService.insertPmRelation(pmRelationVo);
		return pmRelationVo;
	}

	// update
	@RequestMapping(value="/updatePmRelationID",method= {RequestMethod.POST})
	public PmRelationVo updatePmRelation(@RequestBody PmRelationVo pmRelationVo ) throws Exception { 
		int iResult = pmRelationService.updatePmRelation(pmRelationVo);
		return pmRelationVo;
	}

	// Merge List

	@RequestMapping(value="/mergepmRelationID",method= {RequestMethod.POST})
	public PmRelationVo MergePmRelationList(@RequestBody PmRelationSVo pmRelationSVo ) { 
		int iResult = 0;
		for(PmRelationVo vo : pmRelationSVo.getPmRelationListVo()) {
			iResult = iResult + pmRelationService.mergePmRelation(vo);
		}
		PmRelationVo pmRelationVo = new PmRelationVo();
		BeanUtils.copyProperties(pmRelationSVo, pmRelationVo);
		return pmRelationVo;
	}
}
