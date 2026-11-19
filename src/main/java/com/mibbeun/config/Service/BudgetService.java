package com.mibbeun.config.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mibbeun.config.Map.BudgetMap;
import com.mibbeun.config.Vo.BudgetVo;

@Service
public class BudgetService {  
	@Autowired
	BudgetMap budgetMap;

	// // List Select
	public List<BudgetVo> budgetInputListData(BudgetVo budgetVo ) { 
		return budgetMap.SelectBudgetInputList(budgetVo);
	}
	
	public List<BudgetVo> budgetOutputListData(BudgetVo budgetVo ) { 
		return budgetMap.SelectBudgetOutputList(budgetVo);
	}
	
	public List<BudgetVo> budgetOutputListGroupData(BudgetVo budgetVo ) { 
		return budgetMap.SelectBudgetOutputGroupList(budgetVo);
	}
	
	
}
