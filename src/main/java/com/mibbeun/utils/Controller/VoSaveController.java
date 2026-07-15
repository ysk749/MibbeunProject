package com.mibbeun.utils.Controller;
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
import com.mibbeun.utils.Service.VoSaveService;
import com.mibbeun.utils.Vo.VoSaveVo;
import com.mibbeun.utils.Vo.VoSaveSVo;

@RestController
@RequestMapping("/")

public class VoSaveController {  
	@Autowired
	VoSaveService voSaveService;

	// One Select
	@RequestMapping(value="/voSaveOneID",method= {RequestMethod.POST})
	public VoSaveVo SelectVoSaveOne(@RequestBody VoSaveVo voSaveVo ) { 
		VoSaveVo inputVoSaveVo = new VoSaveVo();
		BeanUtils.copyProperties(voSaveVo, inputVoSaveVo);
		VoSaveVo oneVoSaveVo = voSaveService.voSaveOneData(inputVoSaveVo);
		return oneVoSaveVo;
	}

	// Select List
	@RequestMapping(value="/voSaveListID",method= {RequestMethod.POST})
	public VoSaveSVo SelectVoSaveList(@RequestBody VoSaveVo voSaveVo ) { 
		VoSaveVo inputVoSaveVo =  new VoSaveVo();
		BeanUtils.copyProperties(voSaveVo, inputVoSaveVo);
		List<VoSaveVo> voSaveListVo = voSaveService.voSaveListData(inputVoSaveVo);
		VoSaveSVo voSaveSVo =  new VoSaveSVo();
		voSaveSVo.setVoSaveListVo(voSaveListVo);
		return voSaveSVo;
	}

	// insert
	@RequestMapping(value="/insertvoSaveID",method= {RequestMethod.POST})
	public VoSaveVo insertVoSave(@RequestBody VoSaveVo voSaveVo ) throws Exception { 
		int iResult = voSaveService.insertVoSave(voSaveVo);
		return voSaveVo;
	}

	// update
	@RequestMapping(value="/updatevoSaveID",method= {RequestMethod.POST})
	public VoSaveVo updateVoSave(@RequestBody VoSaveVo voSaveVo ) throws Exception { 
		int iResult = voSaveService.updateVoSave(voSaveVo);
		return voSaveVo;
	}

	// Merge List
	@RequestMapping(value="/mergevoSaveID",method= {RequestMethod.POST})
	public VoSaveSVo MergeVoSaveList(@RequestBody VoSaveSVo voSaveSVo ) { 
		int iResult = 0;
		for(VoSaveVo vo : voSaveSVo.getVoSaveListVo()) {
			iResult = iResult + voSaveService.mergeVoSave(vo);
		}
		return voSaveSVo;
	}
}
