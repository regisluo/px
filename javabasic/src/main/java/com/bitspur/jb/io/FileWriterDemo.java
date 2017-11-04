package com.bitspur.jb.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
	public static void main(String[] args) {
		File file = new File("src/main/java/com/bitspur/jb/io/FileWriterDemo.txt");

		Writer wr = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			wr = new FileWriter(file, true);
			wr.write("this is used to write to a file");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(wr);
		}

		try (FileReader fr = new FileReader(file);) {
			char[] cbuf = new char[256];
			StringBuilder sb = new StringBuilder();
			int n = fr.read(cbuf);
			while (n > 0) {
				sb.append(new String(cbuf));
				n = fr.read(cbuf);
			}
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
