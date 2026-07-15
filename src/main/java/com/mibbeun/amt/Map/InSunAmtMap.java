package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.InSunAmtVo;

@Mapper
public interface InSunAmtMap {  
		InSunAmtVo  SelectInSunAmt(InSunAmtVo inSunAmtVo);

		List<InSunAmtVo>  SelectInSunAmtList(InSunAmtVo inSunAmtVo);

		int InsertInSunAmt(InSunAmtVo inSunAmtVo);

		int UpdateInSunAmt(InSunAmtVo inSunAmtVo);
		int DeleteInSunAmt(InSunAmtVo inSunAmtVo);
		int MergeInSunAmt(InSunAmtVo inSunAmtVo);
		InSunAmtVo SumInSunAmt(InSunAmtVo inSunAmtVo);
}
