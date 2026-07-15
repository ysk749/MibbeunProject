package com.mibbeun.amt.Map;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mibbeun.amt.Vo.InputFamilySumVo;

@Mapper
public interface InputFamilySumMap {  
	List<InputFamilySumVo>  SelectInputFamilySumList1(InputFamilySumVo inputFamilySumVo);
	List<InputFamilySumVo>  SelectInputFamilySumList2(InputFamilySumVo inputFamilySumVo);
	List<InputFamilySumVo>  SelectInputFamilySumList3(InputFamilySumVo inputFamilySumVo);
	List<InputFamilySumVo>  SelectInputFamilySumList4(InputFamilySumVo inputFamilySumVo);
}
