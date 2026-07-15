package com.mibbeun.amt.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.amt.Map.HomeDataMap;
import com.mibbeun.amt.Vo.HomeDataVo;

@Service
public class HomeDataService {  
	@Autowired
	HomeDataMap homeDataMap;

	// One Select
	public int deleteOutOtherHomeCodeGb(HomeDataVo homeDataVo ) { 
		return homeDataMap.DeleteOutOtherHomeCodeGb(homeDataVo);
	}

	public int insertOutOtherHomeCodeGb(HomeDataVo homeDataVo ) { 
		return homeDataMap.InsertOutOtherHomeCodeGb(homeDataVo);
	}
		
	
}
