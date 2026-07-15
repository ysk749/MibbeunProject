package com.mibbeun.code.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.code.Vo.IntputCode3Vo;

@Mapper
public interface IntputCode3Map {  
		IntputCode3Vo  SelectIntputCode3(IntputCode3Vo intputCode3Vo);

		List<IntputCode3Vo>  SelectIntputCode3List(IntputCode3Vo intputCode3Vo);

		int InsertIntputCode3(IntputCode3Vo intputCode3Vo);

		int UpdateIntputCode3(IntputCode3Vo intputCode3Vo);
		int DeleteIntputCode3(IntputCode3Vo intputCode3Vo);
		int MergeIntputCode3(IntputCode3Vo intputCode3Vo);
}
