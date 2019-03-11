package cn.com.kid.test;

public class Test {

	static {
		System.out.println("static");
	}
	
	public Test(){
		System.out.println("test");
	}
	
	public Test(String name){
		System.out.println("test:"+name);
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(){
			@Override
			public void run() {
				pong();
			}
		};
		t.run();
		System.out.println("ping");
	}
	
	static void pong(){
		System.out.println("pong");
	}
}
