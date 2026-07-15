package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.OutputCode3CnteVo;

@Mapper
public interface OutputCode3CnteMap {  
		OutputCode3CnteVo  SelectOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo);

		List<OutputCode3CnteVo>  SelectOutputCode3CnteList(OutputCode3CnteVo outputCode3CnteVo);

		int InsertOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo);

		int UpdateOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo);
		int DeleteOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo);
		
		int MergeOutputCode3Cnte(OutputCode3CnteVo outputCode3CnteVo);
}
