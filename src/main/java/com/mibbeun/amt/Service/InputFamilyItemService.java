package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.InputFamilyItemMap;
import com.mibbeun.amt.Vo.InputFamilyItemVo;

@Service
public class InputFamilyItemService {  
	@Autowired
	InputFamilyItemMap inputFamilyItemMap;

	// List Select
	public List<InputFamilyItemVo> inputFamilyItemListData1(InputFamilyItemVo inputFamilyItemVo ) { 
		return inputFamilyItemMap.SelectInputFamilyItemList1(inputFamilyItemVo);
	}
	
	// List Select
	public List<InputFamilyItemVo> inputFamilyItemListData2(InputFamilyItemVo inputFamilyItemVo ) { 
		return inputFamilyItemMap.SelectInputFamilyItemList2(inputFamilyItemVo);
	}
	
}
