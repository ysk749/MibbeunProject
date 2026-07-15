package com.mibbeun.utils.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.utils.Vo.VoFieldSaveVo;
import com.mibbeun.utils.Vo.VoSaveVo;

@Mapper
public interface VoFieldSaveMap {  
		VoFieldSaveVo  SelectVoFieldSave(VoFieldSaveVo voFieldSaveVo);

		List<VoFieldSaveVo>  SelectVoFieldSaveList(VoFieldSaveVo voFieldSaveVo);

		int InsertVoFieldSave(VoFieldSaveVo voFieldSaveVo);

		int UpdateVoFieldSave(VoFieldSaveVo voFieldSaveVo);
		int DeleteVoFieldSave(VoSaveVo voSaveVo);
		int MergeVoFieldSave(VoFieldSaveVo voFieldSaveVo);
}
