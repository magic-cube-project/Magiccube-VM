/**
 * Project Name:trustsql_sdk
 * File Name:BaseAlgoUtil.java
 * Package Name:com.tencent.trustsql.sdk.algo
 * Date:Jul 26, 20175:54:22 PM
 * Copyright (c) 2017, Tencent All Rights Reserved.
 *
 */

package com.magiccube.blockchain.common.algorithm;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

public class BaseAlgorithm {
	
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * encode bytes
	 * 
	 * @param algorithm  algorithm
	 * @param data  data
	 * @return byte[]
	 */
	public static byte[] encode(String algorithm, byte[] data) {
		if (data == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(data);
			return messageDigest.digest();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * encodeTwice bytes
	 *
	 * @param algorithm  algorithm
	 * @param data data
	 * @return byte[]
	 */
	protected static byte[] encodeTwice(String algorithm, byte[] data) {
		if (data == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(data);
			return messageDigest.digest(messageDigest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
