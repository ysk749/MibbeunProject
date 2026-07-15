package com.mibbeun.login.Controller;
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
import com.mibbeun.login.Service.CodeYearService;
import com.mibbeun.login.Vo.CodeYearVo;

@RestController
@RequestMapping("/")

public class CodeYearController {  
	@Autowired
	CodeYearService codeYearService;

	// One Select
	@RequestMapping(value="/codeYearOneID",method= {RequestMethod.POST})
	public CodeYearVo SelectCodeYearOne(@RequestBody CodeYearVo codeYearVo ) { 
		CodeYearVo inputCodeYearVo = new CodeYearVo();
		BeanUtils.copyProperties(codeYearVo, inputCodeYearVo);
		CodeYearVo oneCodeYearVo = codeYearService.codeYearOneData(inputCodeYearVo);
		return oneCodeYearVo;
	}


	// insert
	@RequestMapping(value="/insertCodeYearID",method= {RequestMethod.POST})
	public CodeYearVo InsertCodeYear(@RequestBody CodeYearVo codeYearVo ) throws Exception { 
		int iResult = codeYearService.insertCodeYear(codeYearVo);
		return codeYearVo;
	}

	// update
	@RequestMapping(value="/updateCodeYearID",method= {RequestMethod.POST})
	public CodeYearVo updateCodeYear(@RequestBody CodeYearVo codeYearVo ) throws Exception { 
		int iResult = codeYearService.updateCodeYear(codeYearVo);
		return codeYearVo;
	}

	// Merge List

	@RequestMapping(value="/mergecodeYearID",method= {RequestMethod.POST})
	public CodeYearVo MergeCodeYearList(@RequestBody CodeYearVo codeYearVo ) { 
		CodeYearVo oneCodeYearVo = codeYearService.codeYearOneData(codeYearVo);
		int iResult = 0;
		if ((oneCodeYearVo == null) || (oneCodeYearVo.getCodeGb() == null) ||
			 (oneCodeYearVo.getCodeGb().endsWith("")== false))
		{
			iResult = codeYearService.insertCodeYear(codeYearVo);
		}
		else
		{
			iResult = codeYearService.updateCodeYear(codeYearVo);
		}
		return codeYearVo;
	}
		
	@RequestMapping(value="/mergecodeYearID_2",method= {RequestMethod.POST})
	public CodeYearVo MergeCodeYearList_2(@RequestBody CodeYearVo codeYearVo ) { 
		int iResult =  codeYearService.mergeCodeYear(codeYearVo);
		CodeYearVo outCodeYearVo = new CodeYearVo();
		BeanUtils.copyProperties(codeYearVo, outCodeYearVo);
		return outCodeYearVo;
	}
}
