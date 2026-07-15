package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.IntputCode2Vo;

@Mapper
public interface IntputCode2Map {  
		IntputCode2Vo  SelectIntputCode2(IntputCode2Vo intputCode2Vo);

		List<IntputCode2Vo>  SelectIntputCode2List(IntputCode2Vo intputCode2Vo);

		int InsertIntputCode2(IntputCode2Vo intputCode2Vo);

		int UpdateIntputCode2(IntputCode2Vo intputCode2Vo);
		
		int DeleteIntputCode2(IntputCode2Vo intputCode2Vo);
		
		int MergeIntputCode2(IntputCode2Vo intputCode2Vo);
}
