package com.bitspur.jb.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		String[] ss = new String[] { "a", "b", "c", "d", "e" };

		OutputStream out = null;
		File file = new File("src/main/java/com/bitspur/jb/io/FileOutputStreamDemo.txt");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			out = new FileOutputStream(file);
			for (String s : ss) {
				out.write(s.getBytes());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(out);
		}

	}
}
