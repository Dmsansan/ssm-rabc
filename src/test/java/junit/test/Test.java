package junit.test;

public class Test {
	public  int add(int a, int b) {
		int c = a+b;
		return c;
	}
	
	public int divide(int a,int b) {
		int c = a/b;
		return c;
	}
	
	public static void main(String[] args) {
		int test = new Test().add(2, 5);
		System.out.println(test);
	}
}	
