package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.InAmtVo;

@Mapper
public interface InAmtMap {  
		InAmtVo  SelectInAmt(InAmtVo inAmtVo);
		InAmtVo  SelectInSunAmt(InAmtVo inAmtVo);

		List<InAmtVo>  SelectInAmtList(InAmtVo inAmtVo);

		int InsertInAmt(InAmtVo inAmtVo);

		int UpdateInAmt(InAmtVo inAmtVo);
		int DeleteInAmt(InAmtVo inAmtVo);
		int MergeInAmt(InAmtVo inAmtVo);
}
