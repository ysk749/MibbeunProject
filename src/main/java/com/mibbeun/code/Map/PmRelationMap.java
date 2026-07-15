package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.PmRelationVo;

@Mapper
public interface PmRelationMap {  
		PmRelationVo  SelectPmRelation(PmRelationVo pmRelationVo);

		List<PmRelationVo>  SelectPmRelationList(PmRelationVo pmRelationVo);

		int InsertPmRelation(PmRelationVo pmRelationVo);

		int UpdatePmRelation(PmRelationVo pmRelationVo);
		int MergePmRelation(PmRelationVo pmRelationVo);
}
