package com.mibbeun.code.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.code.Map.CodeSeqNoMap;
import com.mibbeun.code.Vo.CodeSeqNoVo;

@Service
public class CodeSeqNoService {  
	@Autowired
	CodeSeqNoMap codeSeqNoMap;

	// One Select
	public int getCodeSeqNodata(String clssCode, String divisCode, String codeGb) { 
		CodeSeqNoVo setSeqNoVo = new CodeSeqNoVo();
		CodeSeqNoVo getSeqNoVo = new CodeSeqNoVo();
		setSeqNoVo.setClssCode(clssCode);
		setSeqNoVo.setDivisCode(divisCode);
		setSeqNoVo.setCodeGb(codeGb);
		getSeqNoVo = codeSeqNoMap.SelectCodeSeqNo(setSeqNoVo);
		int iNumber = 1;
		if ((getSeqNoVo.getCodeGb() == null) ||
			(getSeqNoVo.getCodeGb().equalsIgnoreCase("")))	 {
			setSeqNoVo.setNumber(iNumber);	
			codeSeqNoMap.InsertCodeSeqNo(setSeqNoVo);
		}
		else 
		{
			iNumber = getSeqNoVo.getNumber() + 1;
			setSeqNoVo.setNumber(iNumber);
			codeSeqNoMap.UpdateCodeSeqNo(setSeqNoVo);
		}
		return iNumber;
	}
	// List Select
	public List<CodeSeqNoVo> codeSeqNoListData(CodeSeqNoVo codeSeqNoVo ) { 
		return codeSeqNoMap.SelectCodeSeqNoList(codeSeqNoVo);
	}
	// insert
	public int insertCodeSeqNo(CodeSeqNoVo codeSeqNoVo ) { 
		return codeSeqNoMap.InsertCodeSeqNo(codeSeqNoVo);
	}
	// update
	public int updateCodeSeqNo(CodeSeqNoVo codeSeqNoVo ) { 
		return codeSeqNoMap.UpdateCodeSeqNo(codeSeqNoVo);
	}
	// Merge
	public int mergeCodeSeqNo(CodeSeqNoVo codeSeqNoVo ) { 
		return codeSeqNoMap.MergeCodeSeqNo(codeSeqNoVo);
	}
}
