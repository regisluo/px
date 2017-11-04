package com.bitspur.jb.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bitspur.jb.container.Student;

public class GetStudentClassInfo {
	public static void main(String[] args) {
		Class clazz = Student.class;

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}

		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}

	}
}
