package com.bitspur.jb.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;

public class FileCopyDemo {
	public static void main(String[] args) {
		File source = new File("src/main/java/com/bitspur/jb/io/source.txt");
		File dest = new File("src/main/java/com/bitspur/jb/io/dest.txt");
		try {
			if (!dest.exists()) {
				dest.createNewFile();
			}

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
			int b = 0;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}
			bos.flush(); // flush data stored in buf[] into dest file

			BufferedReader br = new BufferedReader(new FileReader(dest));
			LineNumberReader lnr = new LineNumberReader(br);
			String s = null;
			while ((s = lnr.readLine()) != null) {
				System.out.println(lnr.getLineNumber() + ": " + s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
