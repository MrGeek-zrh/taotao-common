package com.taotao.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 对异常信息进行处理，以便于可以从堆栈中获取到异常信息
* <p>Title: ExceptionUtil.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-10-13_16:59:43
* @version 1.0
 */
public class ExceptionUtil {

	public static String getStackTrace(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			//将错误信息打印到输入PrintWriter中
			e.printStackTrace(pw);
			//从StringWriter中去除打印信息
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
