package com.mibbeun.login.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.login.Vo.ProgListVo;

@Mapper
public interface ProgListMap {  
		ProgListVo  SelectProgList(ProgListVo progListVo);

		List<ProgListVo>  SelectProgListList(ProgListVo progListVo);
}
