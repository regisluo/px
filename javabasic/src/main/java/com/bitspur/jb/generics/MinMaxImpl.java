package com.bitspur.jb.generics;

public class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {

	private T[] tt;

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 13, 5, 6, 7, 2, 33, 12, 98 };
		MinMaxImpl<Integer> implForInteger = new MinMaxImpl<>(ints);
		System.out.println(implForInteger.min());
		System.out.println(implForInteger.max());

		Character[] chars = new Character[] { 'w', 'd', 'a', 'm' };
		MinMaxImpl<Character> implForChar = new MinMaxImpl<>(chars);
		System.out.println(implForChar.min());
		System.out.println(implForChar.max());

	}

	public MinMaxImpl(T[] tt) {
		super();
		this.tt = tt;
	}

	public T[] getTt() {
		return tt;
	}

	public void setTt(T[] tt) {
		this.tt = tt;
	}

	@Override
	public T min() {
		T min = null;
		if (tt.length > 0) {
			min = tt[0];
			for (T t : tt) {
				if (t.compareTo(min) < 0) {
					min = t;
				}
			}
		}
		return min;
	}

	@Override
	public T max() {
		T max = null;
		if (tt.length > 0) {
			max = tt[0];
			for (T t : tt) {
				if (t.compareTo(max) > 0) {
					max = t;
				}
			}
		}
		return max;
	}

}
