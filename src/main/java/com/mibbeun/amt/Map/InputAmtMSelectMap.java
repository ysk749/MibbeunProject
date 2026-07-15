package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.InputAmtMSelectVo;

@Mapper
public interface InputAmtMSelectMap {  
		InputAmtMSelectVo  SelectInputAmtMSelect(InputAmtMSelectVo inputAmtMSelectVo);

		List<InputAmtMSelectVo>  SelectInputAmtMSelectList(InputAmtMSelectVo inputAmtMSelectVo);
		
		InputAmtMSelectVo  SelectInputSunAmtMSelect(InputAmtMSelectVo inputAmtMSelectVo);

		List<InputAmtMSelectVo>  SelectInputSunAmtMSelectList(InputAmtMSelectVo inputAmtMSelectVo);		
}
