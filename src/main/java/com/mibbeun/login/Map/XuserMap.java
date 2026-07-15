package com.mibbeun.login.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.login.Vo.XuserVo;

@Mapper
public interface XuserMap {  
		XuserVo  SelectXuser(XuserVo xuserVo);

		int InsertXuser(XuserVo xuserVo);

		int UpdateXuser(XuserVo xuserVo);
		int MergeXuser(XuserVo xuserVo);
}
