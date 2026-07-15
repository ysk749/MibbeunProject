package com.mibbeun.fml.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.fml.Vo.FamilyVo;

@Mapper
public interface FamilyMap {  
		FamilyVo  SelectFamily(FamilyVo familyVo);

		List<FamilyVo>  SelectFamilyList(FamilyVo familyVo);

		int InsertFamily(FamilyVo familyVo);

		int UpdateFamily(FamilyVo familyVo);

		int DeleteFamily(FamilyVo familyVo);

		int MergeFamily(FamilyVo familyVo);
}
