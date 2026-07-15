package com.mibbeun.utils.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.utils.Map.AtchFileMap;
import com.mibbeun.utils.Vo.AtchFileVo;

@Service
public class AtchFileService {  
	@Autowired
	AtchFileMap atchFileMap;

	// One Select
	public AtchFileVo atchFileOneData(AtchFileVo atchFileVo ) { 
		return atchFileMap.SelectAtchFile(atchFileVo);
	}
	// List Select
	public List<AtchFileVo> atchFileListData(AtchFileVo atchFileVo ) { 
		return atchFileMap.SelectAtchFileList(atchFileVo);
	}
	// insert
	public int insertAtchFile(AtchFileVo atchFileVo ) { 
		return atchFileMap.InsertAtchFile(atchFileVo);
	}
	// update
	public int updateAtchFile(AtchFileVo atchFileVo ) { 
		return atchFileMap.UpdateAtchFile(atchFileVo);
	}
	// delete
	public int deleteAtchFile(AtchFileVo atchFileVo ) { 
		return atchFileMap.DeleteAtchFile(atchFileVo);
	}
	// Merge
	public int mergeAtchFile(AtchFileVo atchFileVo ) { 
		return atchFileMap.MergeAtchFile(atchFileVo);
	}
}