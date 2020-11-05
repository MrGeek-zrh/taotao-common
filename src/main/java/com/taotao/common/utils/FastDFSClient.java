package com.taotao.common.utils;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 文件上传工具类
* <p>Title: FastDFSClient.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date Jul 15, 2020
* @version 1.0
 */
public class FastDFSClient {
	
	/**
	 * 通过图片的路径+拓展名上传图片
	 * @param local_filename	想要上传的图片的路径
	 * @param file_ext_name		图片的后缀名
	 * @param meta_list			想要额外添加的内容
	 * @return String[] 		包含有部分图片访问路径的字符串数组
	 * @throws Exception
	 */
	public static String uploadFile(String local_filename, String file_ext_name, NameValuePair[] meta_list) {
		//1. 添加FastDFS 所需的jar 包到pom文件中
		//2. 加载配置文件
		try {
			String path = "properties/client.conf";
			ClientGlobal.init(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. 创建一个trackerClient 对象
		TrackerClient trackerClient = new TrackerClient();
		
		//4. 通过TrackerClient 获取一个trackerServer对象
		TrackerServer trackerServer = null;
		try {
			trackerServer = trackerClient.getTrackerServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. 声明StorageServer 对象
		StorageServer storageServer = null;
		
		//6. 获得StorageClient 对象
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		
		//7. 调用StorageClient 对象的方法上传文件即可
		//返回值是 可以用来在浏览器中访问图片的部分url 
		String[] strings = null;
		try {
			strings = storageClient.upload_file(local_filename, file_ext_name, meta_list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String fileString = "";
		
		for (String string : strings) {
			fileString += string+" ";
		}
		fileString = fileString.trim();
		fileString = fileString.replace(" ", "/");
		return fileString;
	}
	
	
	public static String uploadFile(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) {
		
		//1. 添加FastDFS 所需的jar 包到pom文件中
		//2. 加载配置文件
		try {
			ClientGlobal.init("properties/client.conf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. 创建一个trackerClient 对象
		TrackerClient trackerClient = new TrackerClient();
		
		//4. 通过TrackerClient 获取一个trackerServer对象
		TrackerServer trackerServer = null;
		try {
			trackerServer = trackerClient.getTrackerServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. 声明StorageServer 对象
		StorageServer storageServer = null;
		
		//6. 获得StorageClient 对象
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		
		String[]strings = null;
		try {
			strings = storageClient.upload_file(file_buff, file_ext_name, meta_list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String fileString = "";
		
		for (String string : strings) {
			fileString += string+" ";
		}
		fileString = fileString.trim();
		fileString = fileString.replace(" ", "/");
		return fileString;
	}
	
}
