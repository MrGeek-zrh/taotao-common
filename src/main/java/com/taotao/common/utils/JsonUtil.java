package com.taotao.common.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * java与JSON互相转换
* <p>Title: JsonUtil.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-13_19:40:57
* @version 1.0
 */
public class JsonUtil {
	
	private static final ObjectMapper ow = new ObjectMapper();

	public static String ObjectToJSON(Object obj) {
		String json = null;
		//如果callback 为空，说明为普通请求，直接将Java对象转换成JSON之后，返回即可
		try {
			json = ow.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 将Json 转换为 Object 对象
	* <p>Title: jsonToObject<／p>
	* <p>Description: <／p>
	* @param json
	* @param cls
	* @return
	 */
	public static Object jsonToObject(String json,Class<?>cls) {
		
		Object object = null;
		try {
			object = ow.readValue(json, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	/**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = ow.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = ow.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
}
