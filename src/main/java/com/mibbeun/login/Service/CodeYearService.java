package com.mibbeun.login.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.login.Map.CodeYearMap;
import com.mibbeun.login.Vo.CodeYearVo;

@Service
public class CodeYearService {  
	@Autowired
	CodeYearMap codeYearMap;

	// One Select
	public CodeYearVo codeYearOneData(CodeYearVo codeYearVo ) { 
		return codeYearMap.SelectCodeYear(codeYearVo);
	}
	// List Select
	public List<CodeYearVo> codeYearListData(CodeYearVo codeYearVo ) { 
		return codeYearMap.SelectCodeYearList(codeYearVo);
	}
	// insert
	public int insertCodeYear(CodeYearVo codeYearVo ) { 
		return codeYearMap.InsertCodeYear(codeYearVo);
	}
	// update
	public int updateCodeYear(CodeYearVo codeYearVo ) { 
		return codeYearMap.UpdateCodeYear(codeYearVo);
	}
	// Merge
	public int mergeCodeYear(CodeYearVo codeYearVo ) { 
		return codeYearMap.MergeCodeYear(codeYearVo);
	}
}
