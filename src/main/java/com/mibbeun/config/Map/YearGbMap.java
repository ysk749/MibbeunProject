package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.config.Vo.YearGbVo;

@Mapper
public interface YearGbMap {  
		YearGbVo  SelectYearGb(YearGbVo yearGbVo);

		List<YearGbVo>  SelectYearGbList(YearGbVo yearGbVo);

		int InsertYearGb(YearGbVo yearGbVo);

		int UpdateYearGb(YearGbVo yearGbVo);
		int MergeYearGb(YearGbVo yearGbVo);
}
