package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.OuputAmtMSelectVo;

@Mapper
public interface OuputAmtMSelectMap {  
		OuputAmtMSelectVo  SelectOuputAmtMSelect(OuputAmtMSelectVo ouputAmtMSelectVo);

		List<OuputAmtMSelectVo>  SelectOuputAmtMSelectList(OuputAmtMSelectVo ouputAmtMSelectVo);
}
