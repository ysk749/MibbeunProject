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
import com.mibbeun.code.Service.CodeValueService;
import com.mibbeun.code.Vo.CodeValueVo;
import com.mibbeun.code.Vo.CodeValueSVo;

@RestController
@RequestMapping("/")

public class CodeValueController {  
	@Autowired
	CodeValueService codeValueService;

	// One Select
	@RequestMapping(value="/codeValueOneID",method= {RequestMethod.POST})
	public CodeValueVo SelectCodeValueOne(@RequestBody CodeValueVo codeValueVo ) { 
		CodeValueVo inputCodeValueVo = new CodeValueVo();
		BeanUtils.copyProperties(codeValueVo, inputCodeValueVo);
		CodeValueVo oneCodeValueVo = codeValueService.codeValueOneData(inputCodeValueVo);
		return oneCodeValueVo;
	}

	// Select List

	@RequestMapping(value="/codeValueListID",method= {RequestMethod.POST})
	public CodeValueSVo SelectCodeValueList(@RequestBody CodeValueVo codeValueVo ) { 
		CodeValueVo inputCodeValueVo =  new CodeValueVo();
		BeanUtils.copyProperties(codeValueVo, inputCodeValueVo);
		List<CodeValueVo> codeValueListVo = codeValueService.codeValueListData(inputCodeValueVo);
		CodeValueSVo codeValueSVo =  new CodeValueSVo();
		codeValueSVo.setCodeValueListVo(codeValueListVo);
		return codeValueSVo;
	}

	// insert
	@RequestMapping(value="/insertCodeValueID",method= {RequestMethod.POST})
	public CodeValueVo InsertCodeValue(@RequestBody CodeValueVo codeValueVo ) throws Exception { 
		int iResult = codeValueService.insertCodeValue(codeValueVo);
		return codeValueVo;
	}

	// update
	@RequestMapping(value="/updateCodeValueID",method= {RequestMethod.POST})
	public CodeValueVo updateCodeValue(@RequestBody CodeValueVo codeValueVo ) throws Exception { 
		int iResult = codeValueService.updateCodeValue(codeValueVo);
		return codeValueVo;
	}

	// delete
	@RequestMapping(value="/deleteCodeValueID",method= {RequestMethod.POST})
	public CodeValueVo DeleteCodeValue(@RequestBody CodeValueVo codeValueVo ) throws Exception { 
		int iResult = codeValueService.deleteCodeValue(codeValueVo);
		return codeValueVo;
	}

	// Merge List

	@RequestMapping(value="/mergecodeValueID",method= {RequestMethod.POST})
	public CodeValueVo MergeCodeValueList(@RequestBody CodeValueSVo codeValueSVo ) { 
		int iResult = 0;
		for(CodeValueVo vo : codeValueSVo.getCodeValueListVo()) {
			iResult = iResult + codeValueService.mergeCodeValue(vo);
		}
		CodeValueVo codeValueVo = new CodeValueVo();
		BeanUtils.copyProperties(codeValueSVo, codeValueVo);
		return codeValueVo;
	}
}
