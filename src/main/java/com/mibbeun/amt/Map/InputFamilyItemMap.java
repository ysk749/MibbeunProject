package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.InputFamilyItemVo;

@Mapper
public interface InputFamilyItemMap {  
    	List<InputFamilyItemVo>  SelectInputFamilyItemList1(InputFamilyItemVo inputFamilyItemVo);
		List<InputFamilyItemVo>  SelectInputFamilyItemList2(InputFamilyItemVo inputFamilyItemVo);
}
