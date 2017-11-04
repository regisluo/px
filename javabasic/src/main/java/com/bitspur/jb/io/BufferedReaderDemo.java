package com.bitspur.jb.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderDemo {
	public static void main(String[] args) {
		File file = new File("src/main/java/com/bitspur/jb/io/2.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				System.out.println(s);
				s = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(br);
		}

	}
}
