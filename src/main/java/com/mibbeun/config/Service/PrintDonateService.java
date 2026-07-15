package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.config.Map.PrintDonateMap;
import com.mibbeun.config.Vo.PrintDonateVo;

@Service
public class PrintDonateService {  
	@Autowired
	PrintDonateMap printDonateMap;

	// One Select
	public PrintDonateVo printDonateOneData(PrintDonateVo printDonateVo ) { 
		return printDonateMap.SelectPrintDonate(printDonateVo);
	}
	// List Select
	public List<PrintDonateVo> printDonateListData(PrintDonateVo printDonateVo ) { 
		return printDonateMap.SelectPrintDonateList(printDonateVo);
	}
	// insert
	public int insertPrintDonate(PrintDonateVo printDonateVo ) { 
		return printDonateMap.InsertPrintDonate(printDonateVo);
	}
	// update
	public int updatePrintDonate(PrintDonateVo printDonateVo ) { 
		return printDonateMap.UpdatePrintDonate(printDonateVo);
	}
	// Merge
	public int mergePrintDonate(PrintDonateVo printDonateVo ) { 
		return printDonateMap.MergePrintDonate(printDonateVo);
	}
}
