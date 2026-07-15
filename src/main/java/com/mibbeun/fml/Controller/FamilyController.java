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
import com.mibbeun.fml.Service.FamilyService;
import com.mibbeun.fml.Vo.FamilyVo;
import com.mibbeun.fml.Vo.FamilySVo;

@RestController
@RequestMapping("/")

public class FamilyController {  
	@Autowired
	FamilyService familyService;

	// One Select
	@RequestMapping(value="/familyOneID",method= {RequestMethod.POST})
	public FamilyVo SelectFamilyOne(@RequestBody FamilyVo familyVo ) { 
		FamilyVo inputFamilyVo = new FamilyVo();
		BeanUtils.copyProperties(familyVo, inputFamilyVo);
		FamilyVo oneFamilyVo = familyService.familyOneData(inputFamilyVo);
		return oneFamilyVo;
	}

	// Select List

	@RequestMapping(value="/familyListID",method= {RequestMethod.POST})
	public FamilySVo SelectFamilyList(@RequestBody FamilyVo familyVo ) { 
		FamilyVo inputFamilyVo =  new FamilyVo();
		BeanUtils.copyProperties(familyVo, inputFamilyVo);
		List<FamilyVo> familyListVo = familyService.familyListData(inputFamilyVo);
		FamilySVo familySVo =  new FamilySVo();
		familySVo.setFamilyListVo(familyListVo);
		return familySVo;
	}
	
	// insert
	@RequestMapping(value="/insertFamilyID",method= {RequestMethod.POST})
	public FamilyVo InsertFamily(@RequestBody FamilyVo familyVo ) throws Exception { 
		int iResult = familyService.insertFamily(familyVo);
		return familyVo;
	}

	// update
	@RequestMapping(value="/updateFamilyID",method= {RequestMethod.POST})
	public FamilyVo updateFamily(@RequestBody FamilyVo familyVo ) throws Exception { 
		int iResult = familyService.updateFamily(familyVo);
		return familyVo;
	}

	// delete
	@RequestMapping(value="/deleteFamilyID",method= {RequestMethod.POST})
	public FamilyVo DeleteFamily(@RequestBody FamilyVo familyVo ) throws Exception { 
		int iResult = familyService.deleteFamily(familyVo);
		return familyVo;
	}

	// Merge List

	@RequestMapping(value="/mergefamilyID",method= {RequestMethod.POST})
	public FamilyVo MergeFamilyList(@RequestBody FamilySVo familySVo ) { 
		int iResult = 0;
		for(FamilyVo vo : familySVo.getFamilyListVo()) {
			iResult = iResult + familyService.mergeFamily(vo);
		}
		FamilyVo familyVo = new FamilyVo();
		BeanUtils.copyProperties(familySVo, familyVo);
		return familyVo;
	}
}
