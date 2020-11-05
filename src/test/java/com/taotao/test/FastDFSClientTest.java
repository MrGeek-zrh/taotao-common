package com.taotao.test;

import java.io.FileInputStream;

import org.junit.Test;

import com.taotao.common.utils.FastDFSClient;

public class FastDFSClientTest {

	/**
	 * 通过文件的路径、文件的拓展名上传图片
	 * @throws Exception
	 */
	@Test
	public void testFastDFSClientByPath() throws Exception {
		String strings = FastDFSClient.uploadFile("//home//mrgeek//download//software1//workspace//TaotaoMailProject//taotao-common//src//main//resources//timg1.jpg", "jpg", null);
		System.out.println(strings);
	}
	
	/**
	 * 通过图片字节数组和拓展名上传图片
	 * @throws Exception
	 */
	@Test
	public void testFastDFSClientByByteArray() throws Exception {
		
		FileInputStream fin;
        byte[] bytes = null;
		fin = new FileInputStream("//home//mrgeek//download//software1//workspace//TaotaoMailProject//taotao-common//src//main//resources//timg1.jpg");
		bytes  = new byte[fin.available()];  
        //将文件内容写入字节数组
        fin.read(bytes);  
        fin.close();  
		
		String string = FastDFSClient.uploadFile(bytes,"jpg" , null);
		System.out.println(string);
	}
	
}
