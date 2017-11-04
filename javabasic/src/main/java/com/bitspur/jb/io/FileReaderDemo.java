package com.bitspur.jb.io;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo {
	public static void main(String[] args) {
		File file = new File("src/main/java/com/bitspur/jb/io/2.txt");
		Reader fr = null;
		try {
			fr = new FileReader(file);
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[256];
			int n = fr.read(cbuf);
			while (n > 0) {
				sb.append(new String(cbuf));
				n = fr.read(cbuf);
			}
			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
