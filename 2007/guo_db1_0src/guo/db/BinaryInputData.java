package guo.db;

import java.io.InputStream;

/**
 * 
 * BinaryInputData.java
 * @Author:¹ùÉÐ²¨
 * @Email:gsb7814@126.com
 * Nov 30, 2007 11:37:34 PM
 */
class BinaryInputData {

	public BinaryInputData(InputStream inputStream, int length) {
		this.inputStream = inputStream;
		this.length = length;
	}

	public InputStream inputStream;
	public int length;
}
