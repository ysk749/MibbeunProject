package com.mibbeun.config.Controller;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mibbeun.config.Service.BudgetService;
import com.mibbeun.config.Vo.BudgetVo;
import com.mibbeun.config.Vo.BudgetSVo;

@RestController
@RequestMapping("/")

public class BudgetController {  
	@Autowired
	BudgetService budgetService;


	// Select List
	@RequestMapping(value="/budgetInputListID",method= {RequestMethod.POST})
	public BudgetSVo SelectBudgetInputList(@RequestBody BudgetVo budgetVo ) { 
		List<BudgetVo> budgetListVo = budgetService.budgetInputListData(budgetVo);
		BudgetSVo outBudgetSVo =  new BudgetSVo();
		outBudgetSVo.setBudgetListVo(budgetListVo);
		return outBudgetSVo;
	}
	
	// Select List
	@RequestMapping(value="/budgetOutputListID",method= {RequestMethod.POST})
	public BudgetSVo SelectBudgetOutputList(@RequestBody BudgetVo budgetVo ) { 
		List<BudgetVo> budgetListVo = budgetService.budgetOutputListData(budgetVo);
		BudgetSVo outBudgetSVo =  new BudgetSVo();
		outBudgetSVo.setBudgetListVo(budgetListVo);
		return outBudgetSVo;
	}	
}
