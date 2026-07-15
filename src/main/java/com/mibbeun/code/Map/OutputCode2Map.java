package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mibbeun.code.Vo.OutputCode1Vo;
import com.mibbeun.code.Vo.OutputCode2Vo;

@Mapper
public interface OutputCode2Map {  
		OutputCode2Vo  SelectOutputCode2(OutputCode2Vo outputCode2Vo);

		List<OutputCode2Vo>  SelectOutputCode2List(OutputCode2Vo outputCode2Vo);

		int InsertOutputCode2(OutputCode2Vo outputCode2Vo);

		int UpdateOutputCode2(OutputCode2Vo outputCode2Vo);
		
		int DeleteOutputCode2(OutputCode2Vo outputCode2Vo);
		
		int MergeOutputCode2(OutputCode2Vo outputCode2Vo);
}
