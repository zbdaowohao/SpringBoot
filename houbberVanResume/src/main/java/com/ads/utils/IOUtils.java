package com.ads.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOUtils {

	public static String readText(String reletivePath) {
		ClassLoader classLoader = IOUtils.class.getClassLoader();
		String path = classLoader.getResource(reletivePath).getFile();
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
				// 添加换行符
				sb.append("\r\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		//System.out.println(sb);
		return sb.replace(sb.lastIndexOf("\r\n"), sb.length(), "").toString();
	}

}
