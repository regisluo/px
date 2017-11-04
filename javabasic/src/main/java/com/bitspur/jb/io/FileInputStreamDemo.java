package com.bitspur.jb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		File txt1 = new File("src/main/java/com/bitspur/jb/io/FileInputStreamDemo.txt");

		InputStream in = null;

		try {
			in = new FileInputStream(txt1);
			byte[] b = new byte[(int) txt1.length()];
			int aByte = in.read();
			int i = 0;
			while (aByte > 0) {
				b[i] = (byte) aByte; // store the read byte to int array
				aByte = in.read(); // read the next byte
				i++;
			}
			System.out.println(new String(b));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
