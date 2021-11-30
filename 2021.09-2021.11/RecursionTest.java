package practice;

import java.util.ArrayList;
import java.util.List;

public class RecursionTest {
	public static void main(String[] args) {
//		System.out.println("1번 답---------------------");
//		1. 1부터 9까지 출력하기
//		pr(0);
//		System.out.println("2번 답---------------------");
//		2. 1부터 10까지의 합을 출력하는 재귀함수를 만드시오?
//		doSum(0,10);
//		System.out.println("3번 답---------------------");
//		3. 팩토리얼
//		int result = fact(4);
//		System.out.println(result);	
//		System.out.println("4번 답---------------------");
//		4. 자연수를 넣어 그 각자리의 수의 합을 반환하는 재귀함수를 만들어라
//		int sum = digitSum(12356,0);
//		System.out.println("sum:" + sum);
//		System.out.println("5번 답---------------------");
//		5. 문자열을 전달받아 그문자사이에 ,를 결합하여 반환하는 재귀함수를 만들어라
//		String s = doStringComma("korea","");
//		k,o,r,e,a
//		System.out.println(s);
//		System.out.println("6번 답---------------------");
//		6. 피보나치수열 10개를 출력하라
//		for(int i = 1; i <= 10;i++) {
//			System.out.println(fibo(i));
//		}
		System.out.println("7번 답---------------------");
//		7. 2진수 3자리를 구성할 수 있는 재귀함수를 만들어라
		doMakeBinary(3,"");
//		System.out.println("끝---------------------");
	}
	
	static void doMakeBinary(int num,String result) {
		if(num==0) {
			System.out.println(result);
			return;
		}
		doMakeBinary(num-1, result+"0");
//		result =result.substring(0, result.length()-1);
		doMakeBinary(num-1, result+"1");
	}
	
	
	static int fibo(int num) {
		if(num<=2) {
			return 1;
		}
		
		return fibo(num-2)+fibo(num-1);
	}
	
	
	static String doStringComma(String str,String result) {
		if(str.length()==0) {
			return result.substring(0, result.length()-1);
		}
		String temp = str.substring(1);
		result += str.charAt(0)+","; 
		return doStringComma(temp,result);
	}
	
	static void pr(int num) {
		if(num==9) {
			return;
		}
		System.out.println(num+1);
		pr(num+1);
	}
	
	static void doSum(int sum,int num) {
		if(num==0) {
			System.out.println(sum);
			return;
		}
		sum = sum+num;
		doSum(sum,num-1);
	}
	
	static int fact(int num) {
		if(num==1) {
			return 1;
		}
		return num * fact(num-1);
	}
	
	static int digitSum(int num,int sum) {
		if(num==0)	{
			return sum;
		}
		int mok = num/10;
		int nam = num%10;
		return digitSum(mok,sum+nam);
		
	}
}
