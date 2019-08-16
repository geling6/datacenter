package com.autohome.datacenter.bean.es;

/**
 * @author houxuesong
 * @date 2019-06-06 09:29
 * @desc 元数据列信息
 */
public class ESColumn {
	/**
	 * 列位置索引
	 */
	private Integer index;
	/**
	 * 列名
	 */
	private String name;
	/**
	 * 列类型
	 */
	private String type;
	/**
	 * 列注解
	 */
	private String comment;
	
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
