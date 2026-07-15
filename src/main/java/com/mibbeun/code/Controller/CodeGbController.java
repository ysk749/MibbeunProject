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
import com.mibbeun.code.Service.CodeGbService;
import com.mibbeun.code.Vo.CodeGbVo;
import com.mibbeun.code.Vo.CodeGbSVo;

@RestController
@RequestMapping("/")

public class CodeGbController {  
	@Autowired
	CodeGbService codeGbService;

	// One Select
	@RequestMapping(value="/codeGbOneID",method= {RequestMethod.POST})
	public CodeGbVo SelectCodeGbOne(@RequestBody CodeGbVo codeGbVo ) { 
		CodeGbVo inputCodeGbVo = new CodeGbVo();
		BeanUtils.copyProperties(codeGbVo, inputCodeGbVo);
		CodeGbVo oneCodeGbVo = codeGbService.codeGbOneData(inputCodeGbVo);
		return oneCodeGbVo;
	}

	// Select List

	@RequestMapping(value="/codeGbListID",method= {RequestMethod.POST})
	public CodeGbSVo SelectCodeGbList(@RequestBody CodeGbVo codeGbVo ) { 
		CodeGbVo inputCodeGbVo =  new CodeGbVo();
		BeanUtils.copyProperties(codeGbVo, inputCodeGbVo);
		List<CodeGbVo> codeGbListVo = codeGbService.codeGbListData(inputCodeGbVo);
		CodeGbSVo codeGbSVo =  new CodeGbSVo();
		codeGbSVo.setCodeGbListVo(codeGbListVo);
		return codeGbSVo;
	}

	// insert
	@RequestMapping(value="/insertCodeGbID",method= {RequestMethod.POST})
	public CodeGbVo InsertCodeGb(@RequestBody CodeGbVo codeGbVo ) throws Exception { 
		int iResult = codeGbService.insertCodeGb(codeGbVo);
		return codeGbVo;
	}

	// update
	@RequestMapping(value="/updateCodeGbID",method= {RequestMethod.POST})
	public CodeGbVo updateCodeGb(@RequestBody CodeGbVo codeGbVo ) throws Exception { 
		int iResult = codeGbService.updateCodeGb(codeGbVo);
		return codeGbVo;
	}

	// Merge List

	@RequestMapping(value="/mergecodeGbID",method= {RequestMethod.POST})
	public CodeGbVo MergeCodeGbList(@RequestBody CodeGbSVo codeGbSVo ) { 
		int iResult = 0;
		for(CodeGbVo vo : codeGbSVo.getCodeGbListVo()) {
			iResult = iResult + codeGbService.mergeCodeGb(vo);
		}
		CodeGbVo codeGbVo = new CodeGbVo();
		BeanUtils.copyProperties(codeGbSVo, codeGbVo);
		return codeGbVo;
	}
}
