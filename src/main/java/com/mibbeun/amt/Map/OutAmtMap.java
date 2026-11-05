package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.OutAmtVo;

@Mapper
public interface OutAmtMap {  
		
  	    int DeleteOutOtherDataAmt(OutAmtVo outAmtVo);
	    int InsertOutOtherDataAmt(OutAmtVo outAmtVo);
	
	    OutAmtVo  SelectOutAmt(OutAmtVo outAmtVo);

		List<OutAmtVo>  SelectOutAmtList(OutAmtVo outAmtVo);

		int InsertOutAmt(OutAmtVo outAmtVo);
		int InsertInfoToOutAmt(OutAmtVo outAmtVo);

		int UpdateOutAmt(OutAmtVo outAmtVo);
		int DeleteOutAmt(OutAmtVo outAmtVo);
		int MergeOutAmt(OutAmtVo outAmtVo);
}
