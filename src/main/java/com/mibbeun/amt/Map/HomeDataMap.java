package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.HomeDataVo;

@Mapper
public interface HomeDataMap {  
		
  	    int DeleteOutOtherHomeCodeGb(HomeDataVo homeDataVo);
	    int InsertOutOtherHomeCodeGb(HomeDataVo homeDataVo);

}
