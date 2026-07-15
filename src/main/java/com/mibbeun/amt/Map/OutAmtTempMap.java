package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.OutAmtTempVo;

@Mapper
public interface OutAmtTempMap {  
		OutAmtTempVo  SelectOutAmtTemp(OutAmtTempVo outAmtTempVo);

		List<OutAmtTempVo>  SelectOutAmtTempList(OutAmtTempVo outAmtTempVo);

		int InsertOutAmtTemp(OutAmtTempVo outAmtTempVo);

		int UpdateOutAmtTemp(OutAmtTempVo outAmtTempVo);
		
		int DeleteOutAmtTemp(OutAmtTempVo outAmtTempVo);
		int UpdateUsrAmtTemp(OutAmtTempVo outAmtTempVo);
		
		int MergeOutAmtTemp(OutAmtTempVo outAmtTempVo);
}
