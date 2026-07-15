package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.OutputCode3Vo;

@Mapper
public interface OutputCode3Map {  
		OutputCode3Vo  SelectOutputCode3(OutputCode3Vo outputCode3Vo);

		List<OutputCode3Vo>  SelectOutputCode3List(OutputCode3Vo outputCode3Vo);

		int InsertOutputCode3(OutputCode3Vo outputCode3Vo);

		int UpdateOutputCode3(OutputCode3Vo outputCode3Vo);
		
		int DeleteOutputCode3(OutputCode3Vo outputCode3Vo);
		
		int MergeOutputCode3(OutputCode3Vo outputCode3Vo);
}
