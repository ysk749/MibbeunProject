package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.OutputCode3CnteMap;
import com.mibbeun.code.Vo.OutputCode3CnteVo;

@Service
public class OutputCode3CnteService {  
	@Autowired
	OutputCode3CnteMap outputCode3CnteMap;

	// One Select
	public OutputCode3CnteVo outputCode3CnteOneData(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.SelectOutputCode3Cnte(outputCode3CnteVo);
	}
	// List Select
	public List<OutputCode3CnteVo> outputCode3CnteListData(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.SelectOutputCode3CnteList(outputCode3CnteVo);
	}
	// insert
	public int insertOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.InsertOutputCode3Cnte(outputCode3CnteVo);
	}
	// update
	public int updateOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.UpdateOutputCode3Cnte(outputCode3CnteVo);
	}
	
	// update
	public int deleteOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.DeleteOutputCode3Cnte(outputCode3CnteVo);
	}
	
	// Merge
	public int mergeOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo ) { 
		return outputCode3CnteMap.MergeOutputCode3Cnte(outputCode3CnteVo);
	}
}
