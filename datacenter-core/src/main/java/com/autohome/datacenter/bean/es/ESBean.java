package com.autohome.datacenter.bean.es;

import java.util.List;

/**
 * @author houxuesong
 * @date 2019-06-06 09:16
 * @desc es数据类
 */
public class ESBean {
	/**
	 * 域名/ip
	 */
	private String hostName;
	/**
	 * 数据库名
	 */
	private String dbName;
	/**
	 * 数据库表名
	 */
	private String tableName;
	/**
	 * 表注释
	 */
	private String tableComment;
	/**
	 * 表类型:1hive表,2mysql表,3sqlserver表
	 */
	private Integer tableType;
	/**
	 * 月使用次数
	 */
	private Integer useCountInMonth;
	
	/**
	 * 列信息
	 */
	private List<ESColumn> columns;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public Integer getTableType() {
		return tableType;
	}
	public void setTableType(Integer tableType) {
		this.tableType = tableType;
	}
	public Integer getUseCountInMonth() {
		return useCountInMonth;
	}
	public void setUseCountInMonth(Integer useCountInMonth) {
		this.useCountInMonth = useCountInMonth;
	}
	public List<ESColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<ESColumn> columns) {
		this.columns = columns;
	}
	
}
