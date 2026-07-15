package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.InputFamilySumMap;
import com.mibbeun.amt.Vo.InputFamilySumVo;

@Service
public class InputFamilySumService {  
	@Autowired
	InputFamilySumMap inputFamilySumMap;

	// List Select
	public List<InputFamilySumVo> inputFamilySumListData1(InputFamilySumVo inputFamilySumVo ) { 
		return inputFamilySumMap.SelectInputFamilySumList1(inputFamilySumVo);
	}
	
	public List<InputFamilySumVo> inputFamilySumListData2(InputFamilySumVo inputFamilySumVo ) { 
		return inputFamilySumMap.SelectInputFamilySumList2(inputFamilySumVo);
	}

	public List<InputFamilySumVo> inputFamilySumListData3(InputFamilySumVo inputFamilySumVo ) { 
		return inputFamilySumMap.SelectInputFamilySumList3(inputFamilySumVo);
	}

	public List<InputFamilySumVo> inputFamilySumListData4(InputFamilySumVo inputFamilySumVo ) { 
		return inputFamilySumMap.SelectInputFamilySumList4(inputFamilySumVo);
	}
	
	
}
