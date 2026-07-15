package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.IntputCode3Map;
import com.mibbeun.code.Vo.IntputCode3Vo;

@Service
public class IntputCode3Service {  
	@Autowired
	IntputCode3Map intputCode3Map;

	// One Select
	public IntputCode3Vo intputCode3OneData(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.SelectIntputCode3(intputCode3Vo);
	}
	// List Select
	public List<IntputCode3Vo> intputCode3ListData(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.SelectIntputCode3List(intputCode3Vo);
	}
	// insert
	public int insertIntputCode3(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.InsertIntputCode3(intputCode3Vo);
	}
	// update
	public int updateIntputCode3(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.UpdateIntputCode3(intputCode3Vo);
	}
	
	// Delete
	public int deleteIntputCode3(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.DeleteIntputCode3(intputCode3Vo);
	}
	// Merge
	public int mergeIntputCode3(IntputCode3Vo intputCode3Vo ) { 
		return intputCode3Map.MergeIntputCode3(intputCode3Vo);
	}
}
