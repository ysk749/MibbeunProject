package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.SelectAllNameMap;
import com.mibbeun.code.Vo.SelectAllNameVo;

@Service
public class SelectAllNameService {  
	@Autowired
	SelectAllNameMap selectAllNameMap;

	// One Select
	public SelectAllNameVo selectAllNameOneData(SelectAllNameVo selectAllNameVo ) { 
		return selectAllNameMap.SelectSelectAllName(selectAllNameVo);
	}
	// List Select
	public List<SelectAllNameVo> selectAllNameListData(SelectAllNameVo selectAllNameVo ) { 
		return selectAllNameMap.SelectSelectAllNameList(selectAllNameVo);
	}
}
