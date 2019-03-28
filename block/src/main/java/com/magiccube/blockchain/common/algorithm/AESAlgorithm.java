package com.magiccube.blockchain.common.algorithm;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESAlgorithm {

	/**
	 * aesEncode:aes 加密. <br/>
	 *
	 * @author Rony
	 * @param key
	 *            秘钥
	 * @param data
	 *            明文
	 */
	public static byte[] aesEncode(byte[] key, byte[] data) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return cipher.doFinal(data);
	}

	/**
	 * aesDecode: aes 解密. <br/>
	 *
	 * @author Rony
	 * @param key key
	 * @param encryptedText  encryptedText
	 * @return encryptedText
	 * @throws Exception Exception
	 * @since JDK 1.7
	 */
	public static byte[] aesDecode(byte[] key, byte[] encryptedText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return cipher.doFinal(encryptedText);
	}

}
