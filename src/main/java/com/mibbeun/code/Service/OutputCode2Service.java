package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.OutputCode2Map;
import com.mibbeun.code.Vo.OutputCode2Vo;

@Service
public class OutputCode2Service {  
	@Autowired
	OutputCode2Map outputCode2Map;

	// One Select
	public OutputCode2Vo outputCode2OneData(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.SelectOutputCode2(outputCode2Vo);
	}
	// List Select
	public List<OutputCode2Vo> outputCode2ListData(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.SelectOutputCode2List(outputCode2Vo);
	}
	// insert
	public int insertOutputCode2(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.InsertOutputCode2(outputCode2Vo);
	}
	// update
	public int updateOutputCode2(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.UpdateOutputCode2(outputCode2Vo);
	}
	// update
	public int deleteOutputCode2(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.DeleteOutputCode2(outputCode2Vo);
	}	
	// Merge
	public int mergeOutputCode2(OutputCode2Vo outputCode2Vo ) { 
		return outputCode2Map.MergeOutputCode2(outputCode2Vo);
	}
}
