package com.lenovo.lps.farseer.priest2.platform.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.lenovo.lps.farseer.priest2.common.api.PriestPlatformException;

/**
 * 字符串加密解密工具类（使用DES算法）
 * 
 * @author liyi7
 */
public final class DBEncryption {
	private static final Logger logger = Logger.getLogger(DBEncryption.class);

    private static final String ENCRYPT_KEY = "priest-login-project-19890328";
    private static final String CHARSET_UTF8 = "UTF-8";

    private DBEncryption() {
    }
    
	public static String encrypt(String userInputPass, String salt) {
		String plainText = userInputPass + "{" + salt + "}";
		Assert.hasText(plainText, "param is empty");

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		try {
			md.update(plainText.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		byte b[] = md.digest();

		int i;

		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();

	}
	
    
	public static String encryptMD5(String obj) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}

		try {
			md.update(obj.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			throw new PriestPlatformException(e);
		}
		byte b[] = md.digest();

		int i;

		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();

	}

    private static SecretKey loadKey() throws GeneralSecurityException, IOException {
        DESKeySpec dks = new DESKeySpec(ENCRYPT_KEY.getBytes(CHARSET_UTF8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(dks);
    }

    public static String encrypt(String value) {
        try {
            Cipher enCipher = Cipher.getInstance("DES");
            SecretKey key = loadKey();
            enCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = enCipher.doFinal(value.getBytes(CHARSET_UTF8));
            result = Base64.encodeBase64(result);
            return new String(result, CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            return value;
        } catch (Exception e) {
            throw new IllegalArgumentException("Use DES algorithm to encrypt " + value + " error.", e);
        }
    }

    public static String decrypt(String value) {
        try {
            Cipher deCipher = Cipher.getInstance("DES");
            SecretKey key = loadKey();
            deCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = Base64.decodeBase64(value);
            result = deCipher.doFinal(result);
            return new String(result, CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            return value;
        } catch (Exception e) {
            throw new IllegalArgumentException("Use DES algorithm to decrypt " + value + " error.", e);
        }
    }
}
