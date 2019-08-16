package com.autohome.datacenter.criteria;

import java.util.List;

/**
 * @author houxuesong
 * @date 2019-05-26 13:43
 * @desc 表血缘查询条件
 */
public class BloodRelationCriteria {
	/**
	 * 父表id
	 */
	private Integer parentId;
	/**
	 * 父表id
	 */
	private List<Integer> parentIds;
	/**
	 * 子表id
	 */
	private Integer childId;
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getChildId() {
		return childId;
	}
	public void setChildId(Integer childId) {
		this.childId = childId;
	}
	public List<Integer> getParentIds() {
		return parentIds;
	}
	public void setParentIds(List<Integer> parentIds) {
		this.parentIds = parentIds;
	}
	
}
