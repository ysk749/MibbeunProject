package com.mibbeun.config.Controller;
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
import com.mibbeun.config.Service.ContributeService;
import com.mibbeun.config.Vo.ContributeVo;
import com.mibbeun.config.Vo.ContributeSVo;

@RestController
@RequestMapping("/")

public class ContributeController {  
	@Autowired
	ContributeService contributeService;

	// One Select
	@RequestMapping(value="/contributeOneID",method= {RequestMethod.POST})
	public ContributeVo SelectContributeOne(@RequestBody ContributeVo contributeVo ) { 
		ContributeVo inputContributeVo = new ContributeVo();
		BeanUtils.copyProperties(contributeVo, inputContributeVo);
		ContributeVo oneContributeVo = contributeService.contributeOneData(inputContributeVo);
		return oneContributeVo;
	}

	// Select List

	@RequestMapping(value="/contributeListID",method= {RequestMethod.POST})
	public ContributeSVo SelectContributeList(@RequestBody ContributeVo contributeVo ) { 
		ContributeVo inputContributeVo =  new ContributeVo();
		BeanUtils.copyProperties(contributeVo, inputContributeVo);
		List<ContributeVo> contributeListVo = contributeService.contributeListData(inputContributeVo);
		ContributeSVo contributeSVo =  new ContributeSVo();
		contributeSVo.setContributeListVo(contributeListVo);
		return contributeSVo;
	}

	// insert
	@RequestMapping(value="/insertContributeID",method= {RequestMethod.POST})
	public ContributeVo InsertContribute(@RequestBody ContributeVo contributeVo ) throws Exception { 
		int iResult = contributeService.insertContribute(contributeVo);
		return contributeVo;
	}

	// update
	@RequestMapping(value="/updateContributeID",method= {RequestMethod.POST})
	public ContributeVo updateContribute(@RequestBody ContributeVo contributeVo ) throws Exception { 
		int iResult = contributeService.updateContribute(contributeVo);
		return contributeVo;
	}

	// delete
	@RequestMapping(value="/deleteContributeID",method= {RequestMethod.POST})
	public ContributeVo DeleteContribute(@RequestBody ContributeVo contributeVo ) throws Exception { 
		int iResult = contributeService.deleteContribute(contributeVo);
		return contributeVo;
	}
	
	// 이전 기부금을 참조하여 새로 생성
	@RequestMapping(value="/newYearMakeContributeID",method= {RequestMethod.POST})
	public ContributeVo NewyearMakeContribute(@RequestBody ContributeVo contributeVo ) throws Exception { 
		int iResult = contributeService.newYearMakeContribute(contributeVo);
		return contributeVo;
	}
		
	

	// Merge List

	@RequestMapping(value="/mergecontributeID",method= {RequestMethod.POST})
	public ContributeVo MergeContributeList(@RequestBody ContributeSVo contributeSVo ) { 
		int iResult = 0;
		for(ContributeVo vo : contributeSVo.getContributeListVo()) {
			iResult = iResult + contributeService.mergeContribute(vo);
		}
		ContributeVo contributeVo = new ContributeVo();
		BeanUtils.copyProperties(contributeSVo, contributeVo);
		return contributeVo;
	}
}
