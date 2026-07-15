package com.mibbeun.utils.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.utils.Vo.AtchFileVo;

@Mapper
public interface AtchFileMap {  
		AtchFileVo  SelectAtchFile(AtchFileVo atchFileVo);

		List<AtchFileVo>  SelectAtchFileList(AtchFileVo atchFileVo);

		int InsertAtchFile(AtchFileVo atchFileVo);

		int UpdateAtchFile(AtchFileVo atchFileVo);

		int DeleteAtchFile(AtchFileVo atchFileVo);

		int MergeAtchFile(AtchFileVo atchFileVo);
}