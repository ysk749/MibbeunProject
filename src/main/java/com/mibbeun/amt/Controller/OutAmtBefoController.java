package com.mibbeun.amt.Controller;
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
import com.mibbeun.amt.Service.OutAmtBefoService;
import com.mibbeun.amt.Vo.OutAmtBefoVo;
import com.mibbeun.amt.Vo.OutAmtBefoSVo;
import com.mibbeun.amt.Service.OutAmtService;
import com.mibbeun.amt.Vo.OutAmtVo;

@RestController
@RequestMapping("/")

public class OutAmtBefoController {  
	@Autowired
	OutAmtBefoService outAmtBefoService;
	OutAmtService outAmtService;

	// One Select
	@RequestMapping(value="/outAmtBefoOneID",method= {RequestMethod.POST})
	public OutAmtBefoVo SelectOutAmtBefoOne(@RequestBody OutAmtBefoVo outAmtBefoVo ) { 
		OutAmtBefoVo inputOutAmtBefoVo = new OutAmtBefoVo();
		BeanUtils.copyProperties(outAmtBefoVo, inputOutAmtBefoVo);
		OutAmtBefoVo oneOutAmtBefoVo = outAmtBefoService.outAmtBefoOneData(inputOutAmtBefoVo);
		return oneOutAmtBefoVo;
	}

	// Select List

	@RequestMapping(value="/outAmtBefoListID",method= {RequestMethod.POST})
	public OutAmtBefoSVo SelectOutAmtBefoList(@RequestBody OutAmtBefoVo outAmtBefoVo ) { 
		OutAmtBefoVo inputOutAmtBefoVo =  new OutAmtBefoVo();
		BeanUtils.copyProperties(outAmtBefoVo, inputOutAmtBefoVo);
		List<OutAmtBefoVo> outAmtBefoListVo = outAmtBefoService.outAmtBefoListData(inputOutAmtBefoVo);
		OutAmtBefoSVo outAmtBefoSVo =  new OutAmtBefoSVo();
		outAmtBefoSVo.setOutAmtBefoListVo(outAmtBefoListVo);
		return outAmtBefoSVo;
	}

	// insert
	@RequestMapping(value="/insertOutAmtBefoID",method= {RequestMethod.POST})
	public OutAmtBefoVo InsertOutAmtBefo(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		int iResult = outAmtBefoService.insertOutAmtBefo(outAmtBefoVo);
		return outAmtBefoVo;
	}

	
	// insert 처리
	@RequestMapping(value="/BefoToinsertOutAmtID",method= {RequestMethod.POST})
	public OutAmtBefoVo BefoToinsertOutAmtID(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		outAmtBefoVo.setUerYn("y");
		int iResult = outAmtBefoService.insertOutAmtBefo(outAmtBefoVo);
		if (iResult >= 1) {
			OutAmtVo outAmtVo = new OutAmtVo();
			BeanUtils.copyProperties(outAmtBefoVo, outAmtVo);
			iResult = outAmtService.insertOutAmt(outAmtVo); 
					
		}
		return outAmtBefoVo;
	}

	// update
	@RequestMapping(value="/updateOutAmtBefoID",method= {RequestMethod.POST})
	public OutAmtBefoVo updateOutAmtBefo(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		int iResult = outAmtBefoService.updateOutAmtBefo(outAmtBefoVo);
		return outAmtBefoVo;
	}

	@RequestMapping(value="/updateOutAmtBefo2ID",method= {RequestMethod.POST})
	public OutAmtBefoVo updateOutAmtBefo2(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		int iResult = outAmtBefoService.updateOutAmtBefo2(outAmtBefoVo);
		return outAmtBefoVo;
	}
	// delete
	@RequestMapping(value="/deleteOutAmtBefoID",method= {RequestMethod.POST})
	public OutAmtBefoVo DeleteOutAmtBefo(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		int iResult = outAmtBefoService.deleteOutAmtBefo(outAmtBefoVo);
		return outAmtBefoVo;
	}
	// 처리완료
	@RequestMapping(value="/updateUsrAmtBefoID",method= {RequestMethod.POST})
	public OutAmtBefoVo UpdateUsrAmtBefo(@RequestBody OutAmtBefoVo outAmtBefoVo ) throws Exception { 
		int iResult = outAmtBefoService.updateUsrAmtBefo(outAmtBefoVo);
		return outAmtBefoVo;
	}	
	
	@RequestMapping(value="/outAmtBefoInsertListID",method= {RequestMethod.POST})
	public OutAmtBefoVo outAmtBefoInsertList(@RequestBody OutAmtBefoSVo outAmtBefoSVo ) { 
		int iResult = 0;
		for(OutAmtBefoVo vo : outAmtBefoSVo.getOutAmtBefoListVo()) {
			iResult = iResult + outAmtBefoService.insertOutAmtBefo(vo);
		}
		OutAmtBefoVo outAmtBefoVo = new OutAmtBefoVo();
		BeanUtils.copyProperties(outAmtBefoSVo, outAmtBefoVo);
		return outAmtBefoVo;
	}
	
	// Merge List

	@RequestMapping(value="/mergeoutAmtBefoID",method= {RequestMethod.POST})
	public OutAmtBefoVo MergeOutAmtBefoList(@RequestBody OutAmtBefoSVo outAmtBefoSVo ) { 
		int iResult = 0;
		for(OutAmtBefoVo vo : outAmtBefoSVo.getOutAmtBefoListVo()) {
			iResult = iResult + outAmtBefoService.mergeOutAmtBefo(vo);
		}
		OutAmtBefoVo outAmtBefoVo = new OutAmtBefoVo();
		BeanUtils.copyProperties(outAmtBefoSVo, outAmtBefoVo);
		return outAmtBefoVo;
	}
}
