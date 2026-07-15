package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.InputAmtMSelectMap;
import com.mibbeun.amt.Vo.InputAmtMSelectVo;

@Service
public class InputAmtMSelectService {  
	@Autowired
	InputAmtMSelectMap inputAmtMSelectMap;

	// One Select
	public InputAmtMSelectVo inputAmtMSelectOneData(InputAmtMSelectVo inputAmtMSelectVo ) { 
		return inputAmtMSelectMap.SelectInputAmtMSelect(inputAmtMSelectVo);
	}
	// List Select
	public List<InputAmtMSelectVo> inputAmtMSelectListData(InputAmtMSelectVo inputAmtMSelectVo ) { 
		return inputAmtMSelectMap.SelectInputAmtMSelectList(inputAmtMSelectVo);
	}

	// One Select
	public InputAmtMSelectVo inputSunAmtMSelectOneData(InputAmtMSelectVo inputAmtMSelectVo ) { 
		return inputAmtMSelectMap.SelectInputSunAmtMSelect(inputAmtMSelectVo);
	}
	// List Select
	public List<InputAmtMSelectVo> inputSunAmtMSelectListData(InputAmtMSelectVo inputAmtMSelectVo ) { 
		return inputAmtMSelectMap.SelectInputSunAmtMSelectList(inputAmtMSelectVo);
	}	
}
