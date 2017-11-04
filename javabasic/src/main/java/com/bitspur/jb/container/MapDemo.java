package com.bitspur.jb.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapDemo {
	public static void main(String[] args) {
		/*
		 * 1. 创建一个HashMap的实例，key是学生的学号id， value的类型是Student类型 2. 向该map实例中添加3个学生对象
		 * 3. (optional)使用Iterator遍历该map，打印信息： id:name
		 */
		// Map<Integer, Student> students = new HashMap<>();
		// Student s1 = new Student(1, "Jim");
		// Student s2 = new Student(2, "Tom");
		// Student s3 = new Student(3, "Alen");
		//
		// students.put(s1.getId(), s1);
		// students.put(s2.getId(), s2);
		// students.put(s3.getId(), s3);
		//
		// Set<Map.Entry<Integer, Student>> set = students.entrySet();//
		// 将映射容器转换为类集容器
		// Iterator<Map.Entry<Integer, Student>> it = set.iterator(); //
		// 调用迭代器对集合进行遍历
		//
		// while (it.hasNext()) {
		// Map.Entry<Integer, Student> entry = it.next();
		// System.out.println(entry.getKey() + ":" +
		// entry.getValue().getName());
		// }
		Student s4 = new Student(10, "Jim", "1990-10-10");
		Student s5 = new Student(8, "Tom", "1990-10-10");
		Student s6 = new Student(15, "Jim", "1990-10-10");
		System.out.println("=============");
		System.out.println(s4.equals(s5));
		System.out.println(s4.equals(s6));

		List<Student> list = new ArrayList<Student>();
		list.add(s4);
		list.add(s5);
		list.add(s6);

		for (Student s : list) {
			System.out.println(s.getId());
		}
		// Collections.sort(list);
		StudentComparator studentComparator = new StudentComparator();
		Collections.sort(list, studentComparator);
		System.out.println("after sorting...");
		for (Student s : list) {
			System.out.println(s.getId());
		}

	}
}
