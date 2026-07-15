package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.config.Vo.ContributeVo;

@Mapper
public interface ContributeMap {  
		ContributeVo  SelectContribute(ContributeVo contributeVo);

		List<ContributeVo>  SelectContributeList(ContributeVo contributeVo);

		int InsertContribute(ContributeVo contributeVo);

		int UpdateContribute(ContributeVo contributeVo);

		int DeleteContribute(ContributeVo contributeVo);

		//  이전 기부금을 참조하여 새로 생성
		int NewYearMakeContribute(ContributeVo contributeVo);
				
		int MergeContribute(ContributeVo contributeVo);
}
