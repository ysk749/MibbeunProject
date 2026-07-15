package com.mibbeun.login.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.login.Vo.CodeYearVo;

@Mapper
public interface CodeYearMap {  
		CodeYearVo  SelectCodeYear(CodeYearVo codeYearVo);

		List<CodeYearVo>  SelectCodeYearList(CodeYearVo codeYearVo);

		int InsertCodeYear(CodeYearVo codeYearVo);

		int UpdateCodeYear(CodeYearVo codeYearVo);
		int MergeCodeYear(CodeYearVo codeYearVo);
}
