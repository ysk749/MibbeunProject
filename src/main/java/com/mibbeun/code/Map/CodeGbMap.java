package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.CodeGbVo;

@Mapper
public interface CodeGbMap {  
		CodeGbVo  SelectCodeGb(CodeGbVo codeGbVo);

		List<CodeGbVo>  SelectCodeGbList(CodeGbVo codeGbVo);

		int InsertCodeGb(CodeGbVo codeGbVo);

		int UpdateCodeGb(CodeGbVo codeGbVo);
		int MergeCodeGb(CodeGbVo codeGbVo);
}
