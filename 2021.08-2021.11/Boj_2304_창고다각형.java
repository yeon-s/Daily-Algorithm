package practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Boj_2304_창고다각형 {

	static int N;
	static Stick[] arr;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N =sc.nextInt();
		arr = new Stick[N];
		for(int i=0;i<N;i++) {
			arr[i] = new Stick(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
//		for(int i=0;i<N;i++) {
//			System.out.print(arr[i]+" ");			
//		}
		//입력 끝
		
		//최대 값 찾기
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max, arr[i].h);
		}
		//최대값 인덱스 찾기
		int index=0;
		for(int i=0;i<N;i++) {
			if(max==arr[i].h) {
				index = i;
			}
		}
		//제일 높은 곳 x좌표 찾기
		int maxX = arr[index].x;
		//올라가는 면적
		Stack<Integer> stack = new Stack<>();
		int k=0;
		for(int x=0;x<=maxX;x++) {
			if(x==arr[k].x) {
				if(stack.peek()>arr[k].h) {
					stack.push(stack.peek());
					k++;
					continue;
				}else {
					stack.push(arr[k].h);
					k++;
					continue;
				}
			}
			if(stack.isEmpty()) {
				stack.push(0);
				continue;
			}else{
				stack.push(stack.peek());
				continue;
			}
		}


		//내려가는 면적
		Stack<Integer> stack2 = new Stack<>();
		int q=N-1;
		for(int x=(arr[N-1].x)+1;x>maxX;x--) {
			if(x==arr[q].x) {
				if(stack2.peek()>arr[q].h) {
					stack2.push(stack2.peek());
					q--;
					continue;
				}else {
					stack2.push(arr[q].h);
					q--;
					continue;
				}
			}
			if(stack2.isEmpty()) {
				stack2.push(0);
				continue;
			}else{
				stack2.push(stack2.peek());
				continue;
			}
		}
		
		int sum=0;
		while(!stack.isEmpty()) {
			sum = sum+stack.pop();
		}
		int sum2=0;
		while(!stack2.isEmpty()) {
			sum2= sum2+stack2.pop();
		}
		System.out.println(sum+sum2);
	}
	
	
	
	
	static class Stick implements Comparable<Stick>{
		int x;
		int h;
		public Stick(int x, int h) {
			super();
			this.x = x;
			this.h = h;
		}
		
		public Integer getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}

		@Override
		public int compareTo(Stick o) {
		
			return getX().compareTo(o.getX());
		
		}

		@Override
		public String toString() {
			return "Stick [x=" + x + ", h=" + h + "]";
		}

	}
}
