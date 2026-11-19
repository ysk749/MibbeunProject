package com.mibbeun.config.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.config.Vo.BudgetVo;

@Mapper
public interface BudgetMap {  
		BudgetVo  SelectBudget(BudgetVo budgetVo);

		List<BudgetVo>  SelectBudgetInputList(BudgetVo budgetVo);
		List<BudgetVo>  SelectBudgetOutputList(BudgetVo budgetVo);
		List<BudgetVo>  SelectBudgetOutputGroupList(BudgetVo budgetVo);
}
