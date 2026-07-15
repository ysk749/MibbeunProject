package com.mibbeun.fml.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.fml.Vo.TopFamilyVo;

@Mapper
public interface TopFamilyMap {  
		TopFamilyVo  SelectTopFamily(TopFamilyVo topFamilyVo);

		List<TopFamilyVo>  SelectTopFamilyList(TopFamilyVo topFamilyVo);

		int InsertTopFamily(TopFamilyVo topFamilyVo);

		int UpdateTopFamily(TopFamilyVo topFamilyVo);

		int DeleteTopFamily(TopFamilyVo topFamilyVo);

		int MergeTopFamily(TopFamilyVo topFamilyVo);
}
