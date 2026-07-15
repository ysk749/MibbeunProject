package com.mibbeun.config.Controller;
import java.io.IOException;
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
import com.mibbeun.config.Service.CarryOverService;
import com.mibbeun.config.Vo.CarryOverVo;
import com.mibbeun.config.Vo.CarryOverSVo;

@RestController
@RequestMapping("/")

public class CarryOverController {  
	@Autowired
	CarryOverService carryOverService;

	// One Select
	@RequestMapping(value="/carryOverOneID",method= {RequestMethod.POST})
	public CarryOverVo SelectCarryOverOne(@RequestBody CarryOverVo carryOverVo ) { 
		CarryOverVo inputCarryOverVo = new CarryOverVo();
		BeanUtils.copyProperties(carryOverVo, inputCarryOverVo);
		CarryOverVo oneCarryOverVo = carryOverService.carryOverOneData(inputCarryOverVo);
		return oneCarryOverVo;
	}

	// Select List

	@RequestMapping(value="/carryOverListID",method= {RequestMethod.POST})
	public CarryOverSVo SelectCarryOverList(@RequestBody CarryOverVo carryOverVo ) { 
		CarryOverVo inputCarryOverVo =  new CarryOverVo();
		BeanUtils.copyProperties(carryOverVo, inputCarryOverVo);
		List<CarryOverVo> carryOverListVo = carryOverService.carryOverListData(inputCarryOverVo);
		CarryOverSVo carryOverSVo =  new CarryOverSVo();
		carryOverSVo.setCarryOverListVo(carryOverListVo);
		return carryOverSVo;
	}

	// insert
	@RequestMapping(value="/insertCarryOverID",method= {RequestMethod.POST})
	public CarryOverVo InsertCarryOver(@RequestBody CarryOverVo carryOverVo ) throws Exception { 
		int iResult = carryOverService.insertCarryOver(carryOverVo);
		return carryOverVo;
	}

	// update
	@RequestMapping(value="/updateCarryOverID",method= {RequestMethod.POST})
	public CarryOverVo updateCarryOver(@RequestBody CarryOverVo carryOverVo ) throws Exception { 
		int iResult = carryOverService.updateCarryOver(carryOverVo);
		return carryOverVo;
	}

	// update
	@RequestMapping(value="/deleteCarryOverID",method= {RequestMethod.POST})
	public CarryOverVo deleteCarryOver(@RequestBody CarryOverVo carryOverVo ) throws Exception { 
		int iResult = carryOverService.deleteCarryOver(carryOverVo);
		return carryOverVo;
	}	
	// Merge List

	@RequestMapping(value="/mergecarryOverID",method= {RequestMethod.POST})
	public CarryOverVo MergeCarryOverList(@RequestBody CarryOverSVo carryOverSVo ) { 
		int iResult = 0;
		for(CarryOverVo vo : carryOverSVo.getCarryOverListVo()) {
			iResult = iResult + carryOverService.mergeCarryOver(vo);
		}
		CarryOverVo carryOverVo = new CarryOverVo();
		BeanUtils.copyProperties(carryOverSVo, carryOverVo);
		return carryOverVo;
	}
}
