package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.CodeGbMap;
import com.mibbeun.code.Vo.CodeGbVo;

@Service
public class CodeGbService {  
	@Autowired
	CodeGbMap codeGbMap;

	// One Select
	public CodeGbVo codeGbOneData(CodeGbVo codeGbVo ) { 
		return codeGbMap.SelectCodeGb(codeGbVo);
	}
	// List Select
	public List<CodeGbVo> codeGbListData(CodeGbVo codeGbVo ) { 
		return codeGbMap.SelectCodeGbList(codeGbVo);
	}
	// insert
	public int insertCodeGb(CodeGbVo codeGbVo ) { 
		return codeGbMap.InsertCodeGb(codeGbVo);
	}
	// update
	public int updateCodeGb(CodeGbVo codeGbVo ) { 
		return codeGbMap.UpdateCodeGb(codeGbVo);
	}
	// Merge
	public int mergeCodeGb(CodeGbVo codeGbVo ) { 
		return codeGbMap.MergeCodeGb(codeGbVo);
	}
}
