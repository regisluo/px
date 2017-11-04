package com.bitspur.jb.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.bitspur.jb.container.Student;

public class ObjectSerializationDemo {
	public static void main(String[] args) {
		Student student = new Student(1, "JIM");
		File f = new File("src/main/java/com/bitspur/jb/io/student.txt");
		OutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			((ObjectOutputStream) out).writeObject(student);
			System.out.println("The " + student + " has been serialized to a file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceUtil.close(out);
		}
	}
}
