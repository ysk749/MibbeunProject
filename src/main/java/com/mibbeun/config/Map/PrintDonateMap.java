package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.config.Vo.PrintDonateVo;

@Mapper
public interface PrintDonateMap {  
		PrintDonateVo  SelectPrintDonate(PrintDonateVo printDonateVo);

		List<PrintDonateVo>  SelectPrintDonateList(PrintDonateVo printDonateVo);

		int InsertPrintDonate(PrintDonateVo printDonateVo);

		int UpdatePrintDonate(PrintDonateVo printDonateVo);
		int MergePrintDonate(PrintDonateVo printDonateVo);
}
