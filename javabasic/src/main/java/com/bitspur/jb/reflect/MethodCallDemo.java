package com.bitspur.jb.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bitspur.jb.container.Student;

public class MethodCallDemo {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Object object = new Student();

		Class clazz = object.getClass();

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			if (method.getName().equals("setId")) {
				method.invoke(object, 1);
			} else if (method.getName().equals("setName")) {
				method.invoke(object, "Jim");
			} else {
				continue;
			}
		}

		Method getIdMethod = clazz.getDeclaredMethod("getId");
		Method getNameMethod = clazz.getDeclaredMethod("getName");

		System.out.println("id: " + getIdMethod.invoke(object));
		System.out.println("name: " + getNameMethod.invoke(object));

	}
}
