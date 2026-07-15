package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.OutputCodeListVo;

@Mapper
public interface OutputCodeListMap {  
		OutputCodeListVo  SelectOutputCodeList(OutputCodeListVo outputCodeListVo);

		List<OutputCodeListVo>  SelectOutputCodeListList(OutputCodeListVo outputCodeListVo);
}
