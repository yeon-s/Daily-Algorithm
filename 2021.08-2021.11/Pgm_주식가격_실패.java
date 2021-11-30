package practice;

import java.util.Stack;

public class Pgm_주식가격_실패 {

	public static int[] main(int[] prices) {
		int[] answer = new int[prices.length];
		
		Stack<Point> stack = new Stack<>();
		stack.push(new Point(0, prices[0]));
		
		for(int i=1;i<prices.length;i++) {
			int max = stack.peek().price;
			if(prices[i]>=max) {
				stack.push(new Point(i, prices[i]));
			}else {
				while(!stack.isEmpty()) {
					Point current = stack.peek();
					int index = current.index;
					int price = current.price;
					
					if(prices[i]<price) {
						answer[index] = i-index;
						stack.pop();
					}else {
						stack.push(new Point(i, prices[i]));
						break;
					}
					
				}
			}
		}
		
		for(int i=0;i<prices.length;i++) {
			if(answer[i]==0) {
				answer[i] = prices.length-1-i;
			}
		}
		
		
		return answer;

	}

	static class Point{
		int index;
		int price;
		public Point(int index, int price) {
			super();
			this.index = index;
			this.price = price;
		}
		
	}
}
