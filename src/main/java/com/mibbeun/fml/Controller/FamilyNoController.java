package com.mibbeun.fml.Controller;
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

import com.mibbeun.fml.Service.FamilyNoService;
import com.mibbeun.fml.Vo.FamilyNoSVo;
import com.mibbeun.fml.Vo.FamilyNoVo;
import com.mibbeun.fml.Vo.FamilyVo;

@RestController
@RequestMapping("/")

public class FamilyNoController {  
	@Autowired
	FamilyNoService familyNoService;

	// One Select
	@RequestMapping(value="/familyNoOneID",method= {RequestMethod.POST})
	public FamilyNoVo SelectFamilyNoOne(@RequestBody FamilyNoVo familyNoVo ) { 
		FamilyNoVo inputFamilyNoVo = new FamilyNoVo();
		BeanUtils.copyProperties(familyNoVo, inputFamilyNoVo);
		FamilyNoVo oneFamilyNoVo = familyNoService.familyNoOneData(inputFamilyNoVo);
		return oneFamilyNoVo;
	}

	// Select List
	@RequestMapping(value="/familyNoListID",method= {RequestMethod.POST})
	public FamilyNoSVo SelectFamilyNoList(@RequestBody FamilyNoVo familyNoVo ) { 
		List<FamilyNoVo> familyNoListVo = familyNoService.familyNoListData(familyNoVo);
		FamilyNoSVo outFamilyNoSVo =  new FamilyNoSVo();
		outFamilyNoSVo.setFamilyNoListVo(familyNoListVo);
		return outFamilyNoSVo;
	}
	
	@RequestMapping(value="/familyGroupListID",method= {RequestMethod.POST})
	public FamilyNoSVo SelectFamilyGroupList(@RequestBody FamilyNoVo familyNoVo ) { 
		List<FamilyNoVo> familyNoListVo = familyNoService.familyGroupListData(familyNoVo);
		FamilyNoSVo outFamilyNoSVo =  new FamilyNoSVo();
		outFamilyNoSVo.setFamilyNoListVo(familyNoListVo);
		return outFamilyNoSVo;
	}
	
	@RequestMapping(value="/familyNoOneName",method= {RequestMethod.POST})
	public FamilyNoVo familyNoOneName(@RequestBody FamilyNoVo familyNoVo ) { 
		FamilyNoVo inputFamilyNoVo = new FamilyNoVo();
		BeanUtils.copyProperties(familyNoVo, inputFamilyNoVo);
		FamilyNoVo oneFamilyNoVo = familyNoService.familyNoOneName(inputFamilyNoVo);
		return oneFamilyNoVo;
	}
	
	@RequestMapping(value="/maxSeqNoFamilyID",method= {RequestMethod.POST})
	public FamilyNoVo MaxSeqNoFamilyID(@RequestBody FamilyNoVo familyNoVo ) { 
		FamilyNoVo inputFamilyNoVo = new FamilyNoVo();
		BeanUtils.copyProperties(familyNoVo, inputFamilyNoVo);
		FamilyNoVo oneFamilyNoVo = familyNoService.maxSeqNoFamily(inputFamilyNoVo);
		return oneFamilyNoVo;
	}	
	
}
