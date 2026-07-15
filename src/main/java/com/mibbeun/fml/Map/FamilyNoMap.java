package com.mibbeun.fml.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mibbeun.fml.Vo.FamilyNoVo;
import com.mibbeun.fml.Vo.FamilyVo;

@Mapper
public interface FamilyNoMap {  
		FamilyNoVo  SelectFamilyNo(FamilyNoVo familyNoVo);

		List<FamilyNoVo>  SelectFamilyNoList(FamilyNoVo familyNoVo);
		List<FamilyNoVo>  SelectFamilyGroupList(FamilyNoVo familyNoVo);
		
		FamilyNoVo  SelectFamilyNoName(FamilyNoVo familyNoVo);
		FamilyNoVo  MaxSeqNoFamily(FamilyNoVo familyNoVo);
		


}
