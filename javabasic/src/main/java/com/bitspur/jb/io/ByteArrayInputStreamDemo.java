package com.bitspur.jb.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamDemo {
	static byte[] b = new byte[] { 65, 66, 67, 68, 69 };// member variable

	public static void main(String[] args) {
		// byte[] b = new byte[] { 65, 66, 67, 68, 69 }; // local variable
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(b);
			byte[] tmp = new byte[256];
			int i = in.read(tmp);
			while (i > 0) {
				System.out.println(new String(tmp));
				i = in.read(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}
