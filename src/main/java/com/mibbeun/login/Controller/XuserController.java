package com.mibbeun.login.Controller;
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
import com.mibbeun.login.Service.XuserService;
import com.mibbeun.login.Vo.XuserVo;

import jakarta.servlet.http.HttpSession;

import com.mibbeun.login.Vo.XuserSVo;
import java.util.UUID;

@RestController
@RequestMapping("/")

public class XuserController {  
	@Autowired
	XuserService xuserService;

	// One Select
	@RequestMapping(value="/xuserOneID",method= {RequestMethod.POST})
	public XuserVo SelectXuserOne(@RequestBody XuserVo xuserVo,HttpSession session ) { 
		
		UUID uuid = UUID.randomUUID();
		session.setAttribute("USID", uuid.toString());
				 
		XuserVo inputXuserVo = new XuserVo();
		BeanUtils.copyProperties(xuserVo, inputXuserVo);
		XuserVo oneXuserVo = xuserService.xuserOneData(inputXuserVo);
		return oneXuserVo;
	}

	// insert
	@RequestMapping(value="/insertXuserID",method= {RequestMethod.POST})
	public XuserVo InsertXuser(@RequestBody XuserVo xuserVo ) throws Exception { 
		int iResult = xuserService.insertXuser(xuserVo);
		return xuserVo;
	}

	// update
	@RequestMapping(value="/updateXuserID",method= {RequestMethod.POST})
	public XuserVo updateXuser(@RequestBody XuserVo xuserVo ) throws Exception { 
		int iResult = xuserService.updateXuser(xuserVo);
		return xuserVo;
	}

	// Merge List

	@RequestMapping(value="/mergexuserID",method= {RequestMethod.POST})
	public XuserVo MergeXuserList(@RequestBody XuserVo xuserVo ) { 
		int iResult = xuserService.mergeXuser(xuserVo);
		XuserVo outUserVo = new XuserVo();
		BeanUtils.copyProperties(xuserVo, outUserVo);
		return outUserVo;
	}
}
