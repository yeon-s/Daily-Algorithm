package practice;

import java.util.ArrayList;
import java.util.List;

public class Pgm_주식가격2_실패 {

	public static int[] main(int[] prices) {
		int[] answer = new int[prices.length];
		
		List<Point> list = new ArrayList<>();
		
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<prices[i-1]) {
				list.add(new Point(i, prices[i]));
			}
		}
		
		for(int i=0;i<prices.length;i++) {
			for(int j=0;j<list.size();j++) {
				if(list.get(j).index<=i) {
					break;
				}
				if(prices[i]>list.get(j).price) {
					answer[i] = list.get(j).index-i;
					break;
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
