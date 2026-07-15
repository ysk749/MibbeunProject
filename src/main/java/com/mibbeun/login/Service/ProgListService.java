package com.mibbeun.login.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.login.Map.ProgListMap;
import com.mibbeun.login.Vo.ProgListVo;

@Service
public class ProgListService {  
	@Autowired
	ProgListMap progListMap;

	// One Select
	public ProgListVo progListOneData(ProgListVo progListVo ) { 
		return progListMap.SelectProgList(progListVo);
	}
	// List Select
	public List<ProgListVo> progListListData(ProgListVo progListVo ) { 
		return progListMap.SelectProgListList(progListVo);
	}
}
