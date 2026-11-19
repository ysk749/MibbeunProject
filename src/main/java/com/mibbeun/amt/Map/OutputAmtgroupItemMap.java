package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.mibbeun.amt.Vo.OutputAmtgroupItemVo;
import com.mibbeun.amt.Vo.OutputAmtgroupItemSelVo;

@Mapper
public interface OutputAmtgroupItemMap {  
		OutputAmtgroupItemVo  SelectOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo);

		List<OutputAmtgroupItemVo>  SelectOutputAmtgroupItemList(OutputAmtgroupItemVo outputAmtgroupItemVo);

		int InsertOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo);
		
		// List<OutputAmtgroupItemSelVo>  SelectOutputAmtgroupItemSelList(OutputAmtgroupItemSelVo outputAmtgroupItemSelVo);
		List<OutputAmtgroupItemSelVo>  SelectOutputAmtgroupItemSelList(OutputAmtgroupItemSelVo outputAmtgroupItemSelVo);

		//JSON Insert Select
		OutputAmtgroupItemVo InsertOutputAmtgroupItemJson(@Param("jsonData") String jsonData);

		int UpdateOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo);

		int DeleteOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo);

		int MergeOutputAmtgroupItem(OutputAmtgroupItemVo outputAmtgroupItemVo);
}