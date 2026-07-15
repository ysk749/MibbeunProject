package com.mibbeun.utils.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.utils.Vo.VoSaveVo;

@Mapper
public interface VoSaveMap {  
		VoSaveVo  SelectVoSave(VoSaveVo voSaveVo);

		List<VoSaveVo>  SelectVoSaveList(VoSaveVo voSaveVo);

		int InsertVoSave(VoSaveVo voSaveVo);

		int UpdateVoSave(VoSaveVo voSaveVo);
		int MergeVoSave(VoSaveVo voSaveVo);
}
