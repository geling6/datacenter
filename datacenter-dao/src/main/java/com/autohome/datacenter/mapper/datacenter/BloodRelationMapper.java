package com.autohome.datacenter.mapper.datacenter;

import java.util.List;

import com.autohome.datacenter.bean.BloodRelation;
import com.autohome.datacenter.criteria.BloodRelationCriteria;

/**
 * @author houxuesong
 * @date 2019-05-26 13:31
 * @desc 血缘关系数据库接口层
 */
public interface BloodRelationMapper {
	
	/**
	 * @author houxuesong
	 * @date 2019-05-26 13:37
	 * @desc 新增表血缘关系
	 */
	int insert(BloodRelation relation);
	
	/**
	 * @author houxuesong
	 * @date 2019-05-26 13:38
	 * @desc 删除表血缘关系
	 */
	int delete();
	/**
	 * @author houxuesong
	 * @date 2019-05-26 13:39
	 * @desc 查询表血缘关系
	 */
	List<BloodRelation> query(BloodRelationCriteria criteria);
}
