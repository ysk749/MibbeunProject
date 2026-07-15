package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.OutputCode1Vo;

@Mapper
public interface OutputCode1Map {  
		OutputCode1Vo  SelectOutputCode1(OutputCode1Vo outputCode1Vo);

		List<OutputCode1Vo>  SelectOutputCode1List(OutputCode1Vo outputCode1Vo);

		int InsertOutputCode1(OutputCode1Vo outputCode1Vo);

		int UpdateOutputCode1(OutputCode1Vo outputCode1Vo);
		int DeleteOutputCode1(OutputCode1Vo outputCode1Vo);
		int MergeOutputCode1(OutputCode1Vo outputCode1Vo);
}
