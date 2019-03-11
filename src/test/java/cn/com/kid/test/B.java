package cn.com.kid.test;

public class B extends Test{
	static{
		System.out.println("static B");
	}
	
	public B() {
		super();

		System.out.println("B");
	}
	
	public B(String name) {
		System.out.println("B:"+name);
	}

	
	
	public static void main(String[] args) {
		new B("sss");
		String a = "hello";
		String b = "he" + new String("llo");
		System.out.println(a==b);
	}
}
