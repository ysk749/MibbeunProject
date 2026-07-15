package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.IntputCode2Map;
import com.mibbeun.code.Vo.IntputCode2Vo;

@Service
public class IntputCode2Service {  
	@Autowired
	IntputCode2Map intputCode2Map;

	// One Select
	public IntputCode2Vo intputCode2OneData(IntputCode2Vo intputCode2Vo ) { 
		return intputCode2Map.SelectIntputCode2(intputCode2Vo);
	}
	// List Select
	public List<IntputCode2Vo> intputCode2ListData(IntputCode2Vo intputCode2Vo ) { 
		return intputCode2Map.SelectIntputCode2List(intputCode2Vo);
	}
	// insert
	public int insertIntputCode2(IntputCode2Vo intputCode2Vo ) { 

		return intputCode2Map.InsertIntputCode2(intputCode2Vo);
	}
	// update
	public int updateIntputCode2(IntputCode2Vo intputCode2Vo ) { 
		return intputCode2Map.UpdateIntputCode2(intputCode2Vo);
	}
	
	// update
	public int deleteIntputCode2(IntputCode2Vo intputCode2Vo ) { 
		return intputCode2Map.DeleteIntputCode2(intputCode2Vo);
	}
	
	// Merge
	public int mergeIntputCode2(IntputCode2Vo intputCode2Vo ) { 
		return intputCode2Map.MergeIntputCode2(intputCode2Vo);
	}
}
