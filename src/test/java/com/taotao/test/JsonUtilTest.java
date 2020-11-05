package com.taotao.test;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import com.taotao.common.utils.JsonUtil;

/**
 * JsonUtil 测试类
* <p>Title: JsonUtilTest.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-16_09:47:50
* @version 1.0
 */
public class JsonUtilTest {

	@Test
	public void testJsonToObject() throws Exception {
		Map<String, String>map = new HashedMap();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		
		String json = JsonUtil.ObjectToJSON(map);
		System.out.println(json);
		
		@SuppressWarnings("unchecked")
		Map<String,String> map2= (Map<String, String>)JsonUtil.jsonToObject(json, Map.class);
	
		for (Map.Entry<String, String> entry: map2.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
