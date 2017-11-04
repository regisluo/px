package com.bitspur.jb.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
	public static void main(String[] args) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[] { 65, 66, 67, 68, 69 };
		try {
			/*
			 * write the given byte array b into outputstream, in fact the
			 * provided data is saved to buf[] defined in ByteArrayOutputStream
			 * class
			 */
			out.write(b);
			/*
			 * call out.toString() to print out the data in
			 * ByteArrayOutputStream class the method toString() is overridden,
			 * and return a string created from buf[]
			 */
			System.out.println("solution 1: " + out.toString());

			/*
			 * This is another way to get bytes from the stream
			 */
			System.out.println("solution 2: " + new String(out.toByteArray()));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(out);
		}

	}
}
