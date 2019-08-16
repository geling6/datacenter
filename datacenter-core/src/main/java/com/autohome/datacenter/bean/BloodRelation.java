package com.autohome.datacenter.bean;

import java.util.Date;

/**
 * @author houxuesong
 * @date 2019-05-26 13:19
 * @desc 表血缘关系关系
 */
public class BloodRelation {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 父节点id
	 */
	private Integer parentId;
	/**
	 * 父节点名称
	 */
	private String parentName;
	/**
	 * 子节点id
	 */
	private Integer childId;
	/**
	 * 子节点名称
	 */
	private String childName;
	/**
	 * 任务uid
	 */
	private String jobUid;
	/**
	 * 任务名
	 */
	private String jobName;
	/**
	 * 创建时间
	 */
	private Date createdStime;
	/**
	 * 更新时间
	 */
	private Date modifiedStime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getChildId() {
		return childId;
	}
	public void setChildId(Integer childId) {
		this.childId = childId;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getJobUid() {
		return jobUid;
	}
	public void setJobUid(String jobUid) {
		this.jobUid = jobUid;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Date getCreatedStime() {
		return createdStime;
	}
	public void setCreatedStime(Date createdStime) {
		this.createdStime = createdStime;
	}
	public Date getModifiedStime() {
		return modifiedStime;
	}
	public void setModifiedStime(Date modifiedStime) {
		this.modifiedStime = modifiedStime;
	}
}
