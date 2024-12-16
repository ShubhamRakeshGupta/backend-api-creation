package com.example.cruddemo.model;
//Static and default method is a feature of java 8
//we can able to add implemented method in interface using static and default keywords
public interface ATCI {

	String m1();

	default int m2() {
		System.out.println("Called");
		return 0;
	}

	static String s1() {
		System.out.println("static method called from interface ");
		return "abc";
	}
}

class Major implements ATCI {

	@Override
	public String m1() {
		
		return null;
	}
	static String s1() {
		System.out.println("stsic method called ");
		return "abc";
	}
	public static void main(String[] args) {

		
		ATCI a = new Major();
		ATCI.s1();
		a.m2();
		//b.m2();
		Major.s1();
	}

}

/*

Note : we can able to call static and default method from interface by using interface name 
	 

*/