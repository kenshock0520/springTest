package com.example.springTest.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
}
