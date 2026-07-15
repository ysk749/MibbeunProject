package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.OutputCode3Map;
import com.mibbeun.code.Vo.OutputCode3Vo;

@Service
public class OutputCode3Service {  
	@Autowired
	OutputCode3Map outputCode3Map;

	// One Select
	public OutputCode3Vo outputCode3OneData(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.SelectOutputCode3(outputCode3Vo);
	}
	// List Select
	public List<OutputCode3Vo> outputCode3ListData(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.SelectOutputCode3List(outputCode3Vo);
	}
	// insert
	public int insertOutputCode3(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.InsertOutputCode3(outputCode3Vo);
	}
	// update
	public int updateOutputCode3(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.UpdateOutputCode3(outputCode3Vo);
	}
	
	// update
	public int deleteOutputCode3(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.DeleteOutputCode3(outputCode3Vo);
	}
	// Merge
	public int mergeOutputCode3(OutputCode3Vo outputCode3Vo ) { 
		return outputCode3Map.MergeOutputCode3(outputCode3Vo);
	}
}
