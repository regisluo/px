package com.bitspur.jb.jdbc;

import java.util.Date;

/**
 * call RandomId.getKey() to return a random string
 * 
 * @author regisl
 *
 */
public class RandomId {
	public static final long MIN_VALUE = 0x8000000000000000L;

	public static final long MAX_VALUE = 0x7fffffffffffffffL;

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '-', '_' };

	private static String toUnsignedString(long i, int shift) {
		char[] buf = new char[64];
		int charPos = 64;
		int radix = 1 << shift;
		long mask = radix - 1;
		do {
			buf[--charPos] = digits[(int) (i & mask)];
			i >>>= shift;
		} while (i != 0);
		return new String(buf, charPos, (64 - charPos));
	}

	public static String getRand(long i, int j) {
		return toUnsignedString(i, j);
	}

	public static Long getRand() {
		String str1, str2, str3;
		str1 = getRandStr(2);
		str3 = getRandStr(3);
		str2 = (new Date()).getTime() + "";
		return Long.parseLong(str1 + str2 + str3);
	}

	public static String getKey() {
		return getRand(getRand(), 6);
	}

	public static String getRandStr(Integer length) {
		String str = "";
		while (str.length() != length) {
			str = (Math.random() + "").substring(2, 2 + length);
		}
		return str;
	}
}
