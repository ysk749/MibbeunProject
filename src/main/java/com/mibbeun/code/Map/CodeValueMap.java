package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.CodeValueVo;

@Mapper
public interface CodeValueMap {  
		CodeValueVo  SelectCodeValue(CodeValueVo codeValueVo);

		List<CodeValueVo>  SelectCodeValueList(CodeValueVo codeValueVo);

		int InsertCodeValue(CodeValueVo codeValueVo);

		int UpdateCodeValue(CodeValueVo codeValueVo);

		int DeleteCodeValue(CodeValueVo codeValueVo);

		int MergeCodeValue(CodeValueVo codeValueVo);
}
