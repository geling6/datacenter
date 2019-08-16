package com.autohome.datacenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.autohome.datacenter.bean.BloodRelation;
import com.autohome.datacenter.criteria.BloodRelationCriteria;
import com.autohome.datacenter.mapper.datacenter.BloodRelationMapper;

/**
 * @author houxuesong
 * @date 2019-05-26 17:57
 * @desc 表血缘关系dao层
 */
@Repository
public class BloodRelationDao {

	@Autowired
	private BloodRelationMapper bloodRelationMapper;
	
	public List<BloodRelation> query(BloodRelationCriteria criteria){
		
		return bloodRelationMapper.query(criteria);
	}
}
