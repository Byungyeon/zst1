package com.bque.zst1.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bque.zst1.dao.mapinfo.TestMapper;
import com.bque.zst1.utils.SOMap;

@Repository
public class TestDao {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(TestDao.class);
	
	/** The sql session. */
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public ArrayList<SOMap> selectTestList(SOMap params){
		return sqlSession.getMapper(TestMapper.class).selectTestList(params);
	}

}
