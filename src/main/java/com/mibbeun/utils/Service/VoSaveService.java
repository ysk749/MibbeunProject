package com.mibbeun.utils.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.utils.Map.VoSaveMap;
import com.mibbeun.utils.Vo.VoSaveVo;

@Service
public class VoSaveService {  
	@Autowired
	VoSaveMap voSaveMap;

	// One Select
	public VoSaveVo voSaveOneData(VoSaveVo voSaveVo ) { 
		return voSaveMap.SelectVoSave(voSaveVo);
		
	}
	// List Select
	public List<VoSaveVo> voSaveListData(VoSaveVo voSaveVo ) { 
		return voSaveMap.SelectVoSaveList(voSaveVo);
	}
	// insert
	public int insertVoSave(VoSaveVo voSaveVo ) { 
		return voSaveMap.InsertVoSave(voSaveVo);
	}
	// update
	public int updateVoSave(VoSaveVo voSaveVo ) { 
		return voSaveMap.UpdateVoSave(voSaveVo);
	}
	// Merge
	public int mergeVoSave(VoSaveVo voSaveVo ) { 
		return voSaveMap.MergeVoSave(voSaveVo);
	}
}
