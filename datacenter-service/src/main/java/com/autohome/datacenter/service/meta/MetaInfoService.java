package com.autohome.datacenter.service.meta;

import com.autohome.datacenter.bean.es.ESBean;

/**
 * @author houxuesong
 * @date 2019-06-06 09;07
 * @desc hive表操作service接口层
 */
public interface MetaInfoService {

	ESBean queryByESId(String esId);
	
	ESBean queryByHostDbTab(String host, String db, String table);
}
