package com.bitspur.jb.io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) {
		File file = new File("src/main/java/com/bitspur/jb/io/1.dat");

		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.writeUTF("Jim");
			raf.writeFloat((float) 1000.2);

			long pos = raf.getFilePointer();

			raf.writeUTF("Tom");
			raf.writeFloat((float) 333.2);

			raf.seek(pos);
			String s = raf.readUTF();
			float f = raf.readFloat();

			System.out.println(s);
			System.out.println(f);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
