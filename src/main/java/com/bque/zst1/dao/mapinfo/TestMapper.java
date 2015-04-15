package com.bque.zst1.dao.mapinfo;

import java.util.ArrayList;

import com.bque.zst1.utils.SOMap;

/**
 * The Interface TestMapper.
 */
public interface TestMapper {

//	SOMap spSetEggPoint(SOMap params);
	
	/**
	 * select test list
	 * @param SOMap params
	 * @return ArrayList<SOMap>
	 */
	ArrayList<SOMap> selectTestList(SOMap params);
	
//	int insertEggPoint(SOMap params);
	
//	int updateEggPoint(SOMap params);
}
