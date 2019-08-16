package com.autohome.datacenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.autohome.datacenter.bean.BloodRelation;
import com.autohome.datacenter.criteria.BloodRelationCriteria;
import com.autohome.datacenter.dao.BloodRelationDao;
import com.autohome.datacenter.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private BloodRelationDao bloodRelationDao;
	@Autowired
    StringRedisTemplate redisTemplate;
	
	@Override
	public void test() {
		
		BloodRelationCriteria criteria = new BloodRelationCriteria();
		List<BloodRelation> bloods = bloodRelationDao.query(criteria);
		System.out.println("test ..." + bloods);
		
		redisTemplate.opsForValue().set("hello", "world");
		String hello = redisTemplate.opsForValue().get("hello");
		System.out.println(hello);
	}
}
