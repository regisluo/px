package com.bitspur.jb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.bitspur.jb.container.Student;

public class ObjectDeserializationDemo {
	/*
	 * should execute ObjectSerializationDemo first before run this application
	 */
	public static void main(String[] args) {
		File file = new File("src/main/java/com/bitspur/jb/io/student.txt");
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			Student s = (Student) in.readObject();

			System.out.println("The data: " + s + " has been recreated from the file");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
