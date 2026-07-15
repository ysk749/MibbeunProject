package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.SelectAllNameVo;

@Mapper
public interface SelectAllNameMap {  
		SelectAllNameVo  SelectSelectAllName(SelectAllNameVo selectAllNameVo);

		List<SelectAllNameVo>  SelectSelectAllNameList(SelectAllNameVo selectAllNameVo);
}
