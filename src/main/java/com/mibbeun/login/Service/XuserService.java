package com.mibbeun.login.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.login.Map.XuserMap;
import com.mibbeun.login.Vo.XuserVo;

@Service
public class XuserService {  
	@Autowired
	XuserMap xuserMap;

	// One Select
	public XuserVo xuserOneData(XuserVo xuserVo ) { 
		return xuserMap.SelectXuser(xuserVo);
	}

	// insert
	public int insertXuser(XuserVo xuserVo ) { 
		return xuserMap.InsertXuser(xuserVo);
	}
	// update
	public int updateXuser(XuserVo xuserVo ) { 
		return xuserMap.UpdateXuser(xuserVo);
	}
	// Merge
	public int mergeXuser(XuserVo xuserVo ) { 
		return xuserMap.MergeXuser(xuserVo);
	}
}
