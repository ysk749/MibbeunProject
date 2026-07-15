package com.mibbeun.config.Vo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter

public class BudgetSVo {  
	String msgCode;
	String msgName;
	BudgetVo budgetVo;
	List<BudgetVo> budgetListVo;
}
