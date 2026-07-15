package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.OutputCodeListMap;
import com.mibbeun.code.Vo.OutputCodeListVo;

@Service
public class OutputCodeListService {  
	@Autowired
	OutputCodeListMap outputCodeListMap;

	// One Select
	public OutputCodeListVo outputCodeListOneData(OutputCodeListVo outputCodeListVo ) { 
		return outputCodeListMap.SelectOutputCodeList(outputCodeListVo);
	}
	// List Select
	public List<OutputCodeListVo> outputCodeListListData(OutputCodeListVo outputCodeListVo ) { 
		return outputCodeListMap.SelectOutputCodeListList(outputCodeListVo);
	}
}
