package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.OutputCode1Map;
import com.mibbeun.code.Vo.OutputCode1Vo;

@Service
public class OutputCode1Service {  
	@Autowired
	OutputCode1Map outputCode1Map;

	// One Select
	public OutputCode1Vo outputCode1OneData(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.SelectOutputCode1(outputCode1Vo);
	}
	// List Select
	public List<OutputCode1Vo> outputCode1ListData(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.SelectOutputCode1List(outputCode1Vo);
	}
	// insert
	public int insertOutputCode1(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.InsertOutputCode1(outputCode1Vo);
	}
	// update
	public int updateOutputCode1(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.UpdateOutputCode1(outputCode1Vo);
	}
	// update
	public int deleteOutputCode1(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.DeleteOutputCode1(outputCode1Vo);
	}	
	// Merge
	public int mergeOutputCode1(OutputCode1Vo outputCode1Vo ) { 
		return outputCode1Map.MergeOutputCode1(outputCode1Vo);
	}
}
