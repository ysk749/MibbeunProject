package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.CodeSeqNoVo;

@Mapper
public interface CodeSeqNoMap {  
		CodeSeqNoVo  SelectCodeSeqNo(CodeSeqNoVo codeSeqNoVo);

		List<CodeSeqNoVo>  SelectCodeSeqNoList(CodeSeqNoVo codeSeqNoVo);

		int InsertCodeSeqNo(CodeSeqNoVo codeSeqNoVo);

		int UpdateCodeSeqNo(CodeSeqNoVo codeSeqNoVo);
		int MergeCodeSeqNo(CodeSeqNoVo codeSeqNoVo);
}
