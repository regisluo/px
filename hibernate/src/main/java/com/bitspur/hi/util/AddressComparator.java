package com.bitspur.hi.util;


import com.bitspur.hi.entity.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address>{
	public int compare(Address o1, Address o2) {
		int i = 0;
		if(o1.getPostcode()!=null){
			if(o2.getPostcode()!=null){
				i = o1.getPostcode().compareTo(o2.getPostcode());
			}else{
				i = 1;
			}
		}else{
			if(o2.getPostcode()!=null){
				i = -1;
			}else{
				i = 0;
			}
		}
		return i;
	}
}
