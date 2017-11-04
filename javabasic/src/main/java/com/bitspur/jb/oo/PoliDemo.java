package com.bitspur.jb.oo;

public class PoliDemo {
	public static void main(String[] args) {
		SuperClass superObject = new SuperClass();
		SubClass subObject = new SubClass();
		/*
		 * 超类类型的引用可以指向后代类的实例,这个时候就会发生运行时多态：
		 * superToSubRef的静态类型（发生在编译期）是SuperClass； 动态类型（发生在运行期）是SubClass；
		 * 在编译期，发生静态绑定，superToSubRef的method方法绑定的是“0”那个方法体；
		 * 在运行期，发生动态绑定，superToSubRef的动态类型是SubClass，由于在SubClass中override
		 * 了父类中的method方法，因此此时只调用覆盖的方法，即“4”那个方法体
		 */
		SuperClass superToSubRef = subObject;

		// group 1
		superObject.method(superObject, superObject);
		superObject.method(subObject, subObject);
		superObject.method(superToSubRef, superToSubRef);
		System.out.println("");

		// group 2
		subObject.method(superObject, superObject);
		subObject.method(subObject, subObject);
		subObject.method(superToSubRef, superToSubRef);
		System.out.println("");

		// group 3
		superToSubRef.method(superObject, superObject);
		superToSubRef.method(subObject, subObject);
		superToSubRef.method(superToSubRef, superToSubRef);
		System.out.println("");

		// group 4
		superToSubRef.firstMethod(); // 静态方法不参与运行时多态
		superToSubRef.secondMethod(); // 非静态方法有运行时多态

		// group 5
		/*
		 * 成员变量不参与运行时多态
		 */
		System.out.println(superToSubRef.staticString);
		System.out.println(superToSubRef.non_staticString);

	}
}
