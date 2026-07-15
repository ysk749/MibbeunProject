package com.mibbeun.utils.Controller;
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
import com.mibbeun.utils.Service.AtchFileService;
import com.mibbeun.utils.Vo.AtchFileVo;
import com.mibbeun.utils.Vo.AtchFileSVo;

@RestController
@RequestMapping("/")

public class AtchFileController {  
	@Autowired
	AtchFileService atchFileService;

	// One Select
	@RequestMapping(value="/atchFileOneID",method= {RequestMethod.POST})
	public AtchFileVo SelectAtchFileOne(@RequestBody AtchFileVo atchFileVo ) { 
		AtchFileVo inputAtchFileVo = new AtchFileVo();
		BeanUtils.copyProperties(atchFileVo, inputAtchFileVo);
		AtchFileVo oneAtchFileVo = atchFileService.atchFileOneData(inputAtchFileVo);
		return oneAtchFileVo;
	}

	// Select List

	@RequestMapping(value="/atchFileListID",method= {RequestMethod.POST})
	public AtchFileSVo SelectAtchFileList(@RequestBody AtchFileVo atchFileVo ) { 
		AtchFileVo inputAtchFileVo =  new AtchFileVo();
		BeanUtils.copyProperties(atchFileVo, inputAtchFileVo);
		List<AtchFileVo> atchFileListVo = atchFileService.atchFileListData(inputAtchFileVo);
		AtchFileSVo atchFileSVo =  new AtchFileSVo();
		atchFileSVo.setAtchFileListVo(atchFileListVo);
		return atchFileSVo;
	}

	// insert
	@RequestMapping(value="/insertAtchFileID",method= {RequestMethod.POST})
	public AtchFileVo InsertAtchFile(@RequestBody AtchFileVo atchFileVo ) throws Exception { 
		int iResult = atchFileService.insertAtchFile(atchFileVo);
		return atchFileVo;
	}

	// update
	@RequestMapping(value="/updateAtchFileID",method= {RequestMethod.POST})
	public AtchFileVo updateAtchFile(@RequestBody AtchFileVo atchFileVo ) throws Exception { 
		int iResult = atchFileService.updateAtchFile(atchFileVo);
		return atchFileVo;
	}

	// delete
	@RequestMapping(value="/deleteAtchFileID",method= {RequestMethod.POST})
	public AtchFileVo DeleteAtchFile(@RequestBody AtchFileVo atchFileVo ) throws Exception { 
		int iResult = atchFileService.deleteAtchFile(atchFileVo);
		return atchFileVo;
	}

	// Merge List

	@RequestMapping(value="/mergeatchFileID",method= {RequestMethod.POST})
	public AtchFileVo MergeAtchFileList(@RequestBody AtchFileSVo atchFileSVo ) { 
		int iResult = 0;
		for(AtchFileVo vo : atchFileSVo.getAtchFileListVo()) {
			iResult = iResult + atchFileService.mergeAtchFile(vo);
		}
		AtchFileVo atchFileVo = new AtchFileVo();
		BeanUtils.copyProperties(atchFileSVo, atchFileVo);
		return atchFileVo;
	}
}