package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.mibbeun.amt.Vo.OutputAmtgroupInfoVo;

@Mapper
public interface OutputAmtgroupInfoMap {  
		OutputAmtgroupInfoVo  SelectOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo);

		List<OutputAmtgroupInfoVo>  SelectOutputAmtgroupInfoList(OutputAmtgroupInfoVo outputAmtgroupInfoVo);

		int InsertOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo);
		OutputAmtgroupInfoVo InsertOutputAmtgroupInfoJson(@Param("jsonData") String jsonData);

		int UpdateOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo);

		int DeleteOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo);

		int MergeOutputAmtgroupInfo(OutputAmtgroupInfoVo outputAmtgroupInfoVo);
}