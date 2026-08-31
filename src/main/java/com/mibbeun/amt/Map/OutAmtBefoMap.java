package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.OutAmtBefoVo;

@Mapper
public interface OutAmtBefoMap {  
		OutAmtBefoVo  SelectOutAmtBefo(OutAmtBefoVo outAmtBefoVo);

		List<OutAmtBefoVo>  SelectOutAmtBefoList(OutAmtBefoVo outAmtBefoVo);

		int InsertOutAmtBefo(OutAmtBefoVo outAmtBefoVo);
		int InsertOutAmtBefo2(OutAmtBefoVo outAmtBefoVo);

		int UpdateOutAmtBefo(OutAmtBefoVo outAmtBefoVo);
		int UpdateOutAmtBefo2(OutAmtBefoVo outAmtBefoVo);
		
		int DeleteOutAmtBefo(OutAmtBefoVo outAmtBefoVo);
		int UpdateUsrAmtBefo(OutAmtBefoVo outAmtBefoVo);
		
		int MergeOutAmtBefo(OutAmtBefoVo outAmtBefoVo);
}
