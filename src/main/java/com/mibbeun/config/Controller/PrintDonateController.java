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
import com.mibbeun.config.Service.PrintDonateService;
import com.mibbeun.config.Vo.PrintDonateVo;
import com.mibbeun.config.Vo.PrintDonateSVo;

@RestController
@RequestMapping("/")

public class PrintDonateController {  
	@Autowired
	PrintDonateService printDonateService;

	// One Select
	@RequestMapping(value="/printDonateOneID",method= {RequestMethod.POST})
	public PrintDonateVo SelectPrintDonateOne(@RequestBody PrintDonateVo printDonateVo ) { 
		PrintDonateVo inputPrintDonateVo = new PrintDonateVo();
		BeanUtils.copyProperties(printDonateVo, inputPrintDonateVo);
		PrintDonateVo onePrintDonateVo = printDonateService.printDonateOneData(inputPrintDonateVo);
		return onePrintDonateVo;
	}

	// Select List

	@RequestMapping(value="/printDonateListID",method= {RequestMethod.POST})
	public PrintDonateSVo SelectPrintDonateList(@RequestBody PrintDonateVo printDonateVo ) { 
		PrintDonateVo inputPrintDonateVo =  new PrintDonateVo();
		BeanUtils.copyProperties(printDonateVo, inputPrintDonateVo);
		List<PrintDonateVo> printDonateListVo = printDonateService.printDonateListData(inputPrintDonateVo);
		PrintDonateSVo printDonateSVo =  new PrintDonateSVo();
		printDonateSVo.setPrintDonateListVo(printDonateListVo);
		return printDonateSVo;
	}

	// insert
	@RequestMapping(value="/insertPrintDonateID",method= {RequestMethod.POST})
	public PrintDonateVo InsertPrintDonate(@RequestBody PrintDonateVo printDonateVo ) throws Exception { 
		int iResult = printDonateService.insertPrintDonate(printDonateVo);
		return printDonateVo;
	}

	// update
	@RequestMapping(value="/updatePrintDonateID",method= {RequestMethod.POST})
	public PrintDonateVo updatePrintDonate(@RequestBody PrintDonateVo printDonateVo ) throws Exception { 
		int iResult = printDonateService.updatePrintDonate(printDonateVo);
		return printDonateVo;
	}

	// Merge List

	@RequestMapping(value="/mergeprintDonateID",method= {RequestMethod.POST})
	public PrintDonateVo MergePrintDonateList(@RequestBody PrintDonateSVo printDonateSVo ) { 
		int iResult = 0;
		for(PrintDonateVo vo : printDonateSVo.getPrintDonateListVo()) {
			iResult = iResult + printDonateService.mergePrintDonate(vo);
		}
		PrintDonateVo printDonateVo = new PrintDonateVo();
		BeanUtils.copyProperties(printDonateSVo, printDonateVo);
		return printDonateVo;
	}
}
