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
import com.mibbeun.code.Service.CodeSeqNoService;
import com.mibbeun.code.Vo.CodeSeqNoVo;
import com.mibbeun.code.Vo.CodeSeqNoSVo;

@RestController
@RequestMapping("/")

public class CodeSeqNoController {  
	@Autowired
	CodeSeqNoService codeSeqNoService;

	@RequestMapping(value="/codeSeqNoListID",method= {RequestMethod.POST})
	public CodeSeqNoSVo SelectCodeSeqNoList(@RequestBody CodeSeqNoVo codeSeqNoVo ) { 
		CodeSeqNoVo inputCodeSeqNoVo =  new CodeSeqNoVo();
		BeanUtils.copyProperties(codeSeqNoVo, inputCodeSeqNoVo);
		List<CodeSeqNoVo> codeSeqNoListVo = codeSeqNoService.codeSeqNoListData(inputCodeSeqNoVo);
		CodeSeqNoSVo codeSeqNoSVo =  new CodeSeqNoSVo();
		codeSeqNoSVo.setCodeSeqNoListVo(codeSeqNoListVo);
		return codeSeqNoSVo;
	}

	// insert
	@RequestMapping(value="/insertCodeSeqNoID",method= {RequestMethod.POST})
	public CodeSeqNoVo InsertCodeSeqNo(@RequestBody CodeSeqNoVo codeSeqNoVo ) throws Exception { 
		int iResult = codeSeqNoService.insertCodeSeqNo(codeSeqNoVo);
		return codeSeqNoVo;
	}

	// update
	@RequestMapping(value="/updateCodeSeqNoID",method= {RequestMethod.POST})
	public CodeSeqNoVo updateCodeSeqNo(@RequestBody CodeSeqNoVo codeSeqNoVo ) throws Exception { 
		int iResult = codeSeqNoService.updateCodeSeqNo(codeSeqNoVo);
		return codeSeqNoVo;
	}

	// Merge List

	@RequestMapping(value="/mergecodeSeqNoID",method= {RequestMethod.POST})
	public CodeSeqNoVo MergeCodeSeqNoList(@RequestBody CodeSeqNoSVo codeSeqNoSVo ) { 
		int iResult = 0;
		for(CodeSeqNoVo vo : codeSeqNoSVo.getCodeSeqNoListVo()) {
			iResult = iResult + codeSeqNoService.mergeCodeSeqNo(vo);
		}
		CodeSeqNoVo codeSeqNoVo = new CodeSeqNoVo();
		BeanUtils.copyProperties(codeSeqNoSVo, codeSeqNoVo);
		return codeSeqNoVo;
	}
}
