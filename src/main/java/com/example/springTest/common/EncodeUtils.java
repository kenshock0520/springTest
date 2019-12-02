package com.example.springTest.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * エンコードユーティリティ
 */
public class EncodeUtils {

	/**
	 * UTF-8でエンコードした文字列を返します。
	 *
	 * @param filename
	 * @return
	 */
	public static String encodeUtf8(String filename) {
		String encoded = null;

		try {
			encoded = URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
			// should never happens
		}

		return encoded;
	}

	public static String encodeMd5() {
		return DigestUtils.md5Hex("spring:springtest".getBytes());
	}

	public static String encodeBase64() {
		return new String(Base64.encodeBase64("nginx:nginxtest".getBytes()));
	}

	public static void main(String[] args) {
		System.out.println(encodeMd5());
		System.out.println(encodeBase64());
	}
}