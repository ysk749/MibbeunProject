package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.OuputAmtMSelectMap;
import com.mibbeun.amt.Vo.OuputAmtMSelectVo;

@Service
public class OuputAmtMSelectService {  
	@Autowired
	OuputAmtMSelectMap ouputAmtMSelectMap;

	// One Select
	public OuputAmtMSelectVo ouputAmtMSelectOneData(OuputAmtMSelectVo ouputAmtMSelectVo ) { 
		return ouputAmtMSelectMap.SelectOuputAmtMSelect(ouputAmtMSelectVo);
	}
	// List Select
	public List<OuputAmtMSelectVo> ouputAmtMSelectListData(OuputAmtMSelectVo ouputAmtMSelectVo ) { 
		return ouputAmtMSelectMap.SelectOuputAmtMSelectList(ouputAmtMSelectVo);
	}
}
