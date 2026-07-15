package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.CodeValueMap;
import com.mibbeun.code.Vo.CodeValueVo;

@Service
public class CodeValueService {  
	@Autowired
	CodeValueMap codeValueMap;

	// One Select
	public CodeValueVo codeValueOneData(CodeValueVo codeValueVo ) { 
		return codeValueMap.SelectCodeValue(codeValueVo);
	}
	// List Select
	public List<CodeValueVo> codeValueListData(CodeValueVo codeValueVo ) { 
		return codeValueMap.SelectCodeValueList(codeValueVo);
	}
	// insert
	public int insertCodeValue(CodeValueVo codeValueVo ) { 
		return codeValueMap.InsertCodeValue(codeValueVo);
	}
	// update
	public int updateCodeValue(CodeValueVo codeValueVo ) { 
		return codeValueMap.UpdateCodeValue(codeValueVo);
	}
	// delete
	public int deleteCodeValue(CodeValueVo codeValueVo ) { 
		return codeValueMap.DeleteCodeValue(codeValueVo);
	}
	// Merge
	public int mergeCodeValue(CodeValueVo codeValueVo ) { 
		return codeValueMap.MergeCodeValue(codeValueVo);
	}
}
