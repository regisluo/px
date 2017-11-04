package com.bitspur.jb.io;

import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		File s1 = new File("src/main/java/com/bitspur/jb/io/s1.txt");
		File s2 = new File("src/main/java/com/bitspur/jb/io/s2.txt");
		FileList fl = new FileList(s1, s2);
		SequenceInputStream sis = new SequenceInputStream(fl);
		int ch = 0;
		byte[] allData = new byte[(int) s1.length() + (int) s2.length()];
		int i = 0;
		while ((ch = sis.read()) > 0) {
			allData[i] = (byte) ch;
			i++;
		}
		System.out.println(new String(allData));
		ResourceUtil.close(sis);
	}

}
