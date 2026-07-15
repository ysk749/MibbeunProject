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
import com.mibbeun.utils.Service.VoFieldSaveService;
import com.mibbeun.utils.Service.VoSaveService;
import com.mibbeun.utils.Vo.VoFieldSaveVo;
import com.mibbeun.utils.Vo.VoFieldSaveSVo;
import com.mibbeun.utils.Vo.VoSaveVo;

@RestController
@RequestMapping("/")

public class VoFieldSaveController {  
	@Autowired
	VoFieldSaveService voFieldSaveService;
	@Autowired
	VoSaveService voSaveService;

	// One Select
	@RequestMapping(value="/voFieldSaveOneID",method= {RequestMethod.POST})
	public VoFieldSaveVo SelectVoFieldSaveOne(@RequestBody VoFieldSaveVo voFieldSaveVo ) { 
		VoFieldSaveVo inputVoFieldSaveVo = new VoFieldSaveVo();
		BeanUtils.copyProperties(voFieldSaveVo, inputVoFieldSaveVo);
		VoFieldSaveVo oneVoFieldSaveVo = voFieldSaveService.voFieldSaveOneData(inputVoFieldSaveVo);
		return oneVoFieldSaveVo;
	}

	// Select List
	@RequestMapping(value="/voFieldSaveListID",method= {RequestMethod.POST})
	public VoFieldSaveSVo SelectVoFieldSaveList(@RequestBody VoFieldSaveVo voFieldSaveVo ) {
		VoSaveVo voSaveVo = new VoSaveVo();
		BeanUtils.copyProperties(voFieldSaveVo, voSaveVo);	
		voSaveVo = voSaveService.voSaveOneData(voSaveVo);
		
		VoFieldSaveVo inputVoFieldSaveVo =  new VoFieldSaveVo();
		BeanUtils.copyProperties(voFieldSaveVo, inputVoFieldSaveVo);
		List<VoFieldSaveVo> voFieldSaveListVo = voFieldSaveService.voFieldSaveListData(inputVoFieldSaveVo);
		
		
		BeanUtils.copyProperties(voSaveVo,voFieldSaveVo );	
		VoFieldSaveSVo voFieldSaveSVo =  new VoFieldSaveSVo();
		voFieldSaveSVo.setVoFieldSaveListVo(voFieldSaveListVo);
		return voFieldSaveSVo;
	}

	// insert
	@RequestMapping(value="/insertvoFieldSaveID",method= {RequestMethod.POST})
	public VoFieldSaveVo insertVoFieldSave(@RequestBody VoFieldSaveVo voFieldSaveVo ) throws Exception { 
		int iResult = voFieldSaveService.insertVoFieldSave(voFieldSaveVo);
		return voFieldSaveVo;
	}

	// update
	@RequestMapping(value="/updatevoFieldSaveID",method= {RequestMethod.POST})
	public VoFieldSaveVo updateVoFieldSave(@RequestBody VoFieldSaveVo voFieldSaveVo ) throws Exception { 
		int iResult = voFieldSaveService.updateVoFieldSave(voFieldSaveVo);
		return voFieldSaveVo;
	}


	
	// Merge List
	@RequestMapping(value="/mergevoFieldSaveID",method= {RequestMethod.POST})
	public VoFieldSaveVo MergeVoFieldSaveList(@RequestBody VoFieldSaveSVo voFieldSaveSVo ) { 
		int iResult = 0;
		VoSaveVo voSaveVo = new VoSaveVo();
		BeanUtils.copyProperties(voFieldSaveSVo, voSaveVo);
		voSaveService.mergeVoSave(voSaveVo);
		voFieldSaveService.deleteVoFieldSave(voSaveVo);
		for(VoFieldSaveVo vo : voFieldSaveSVo.getVoFieldSaveListVo()) {
			iResult = iResult + voFieldSaveService.mergeVoFieldSave(vo);
		}
		VoFieldSaveVo voFieldSaveVo = new VoFieldSaveVo();
		BeanUtils.copyProperties(voSaveVo, voFieldSaveVo);		
		return voFieldSaveVo;
	}
}
