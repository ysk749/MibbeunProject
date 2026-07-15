package com.mibbeun.amt.Controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mibbeun.amt.Service.HomeDataService;
import com.mibbeun.amt.Vo.HomeDataVo;

@RestController
@RequestMapping("/")

public class OutAmtController {  
	@Autowired
	HomeDataService homeDataService;
	
	
	@RequestMapping(value="/insertOutOtherHomeCodeGbID",method= {RequestMethod.POST})
	public HomeDataVo InsertOutOtherHomeCodeGb(@RequestBody HomeDataVo homeDataVo ) throws Exception { 
		int iResult = homeDataService.deleteOutOtherHomeCodeGb(homeDataVo);
		iResult = homeDataService.insertOutOtherHomeCodeGb(homeDataVo);
		return homeDataVo;
	}	

}
