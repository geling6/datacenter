package com.autohome.datacenter.service.impl.meta;

import org.springframework.stereotype.Service;

import com.autohome.datacenter.bean.es.ESBean;
import com.autohome.datacenter.service.meta.MetaInfoService;

/**
 * @author houxuesong
 * @date 2019-06-06 09:49
 * @desc 元数据信息service层
 */
@Service
public class MetaInfoServiceImpl implements MetaInfoService{

	
	/**
	 * @author houxuesong
	 * @date 2019-06-06 09:56
	 * @desc 根据esId查元数据信息
	 */
	@Override
	public ESBean queryByESId(String esId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author houxuesong
	 * @date 2019-06-06 09:56
	 * @desc 根据主机名,库名,表名查元数据信息(主要适用业务库)
	 */
	@Override
	public ESBean queryByHostDbTab(String host, String db, String table) {
		if(host==null) {
			
		}
		return null;
	}

}
