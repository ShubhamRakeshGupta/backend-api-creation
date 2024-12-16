package com.example.cruddemo.model;

//without abstract method we can create abstract class 
abstract class Dummy2 {
	public void test1() {
		System.out.println("test1 called");
	}

	public abstract void test2(int a);

}

//Every time Abstract class get extends not implemented 
public class Dummy extends Dummy2{

	public static void main(String[] args) {

		Dummy2 d2 = new Dummy();
		d2.test1();
	}

	@Override
	public void test2(int a) {
		
		
	}
}


