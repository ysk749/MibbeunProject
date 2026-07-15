package com.mibbeun.utils.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.utils.Map.VoFieldSaveMap;
import com.mibbeun.utils.Vo.VoFieldSaveVo;
import com.mibbeun.utils.Vo.VoSaveVo;

@Service
public class VoFieldSaveService {  
	@Autowired
	VoFieldSaveMap voFieldSaveMap;

	// One Select
	public VoFieldSaveVo voFieldSaveOneData(VoFieldSaveVo voFieldSaveVo ) { 
		return voFieldSaveMap.SelectVoFieldSave(voFieldSaveVo);
	}
	// List Select
	public List<VoFieldSaveVo> voFieldSaveListData(VoFieldSaveVo voFieldSaveVo ) { 
		return voFieldSaveMap.SelectVoFieldSaveList(voFieldSaveVo);
	}
	// insert
	public int insertVoFieldSave(VoFieldSaveVo voFieldSaveVo ) { 
		return voFieldSaveMap.InsertVoFieldSave(voFieldSaveVo);
	}
	// update
	public int updateVoFieldSave(VoFieldSaveVo voFieldSaveVo ) { 
		return voFieldSaveMap.UpdateVoFieldSave(voFieldSaveVo);
	}
	
	// update
	public int deleteVoFieldSave(VoSaveVo voSaveVo ) { 
		return voFieldSaveMap.DeleteVoFieldSave(voSaveVo);
	}	
	// Merge
	public int mergeVoFieldSave(VoFieldSaveVo voFieldSaveVo ) { 
		return voFieldSaveMap.MergeVoFieldSave(voFieldSaveVo);
	}
}
