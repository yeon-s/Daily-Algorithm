package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2527_직사각형_실패 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		Square one = null;
		Square two = null;
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			one = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			two = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			if(two.xMin>one.xMax || one.xMin>two.xMax || one.yMin>two.yMax || two.yMin>one.yMax) {
				System.out.println("d");
				continue;
			}else if((one.xMax==two.xMin && one.yMax==two.yMin)|| (one.xMax==two.xMin && one.yMin==two.yMax)|| 
					(one.xMin==two.xMax && one.yMin==two.yMax)|| (one.xMin==two.xMax && one.yMax==two.yMin)) {
				System.out.println("c");
				continue;
			}else if((one.xMax==two.xMin && one.yMin< two.yMin && two.yMin < one.yMax) ||
					(one.xMax==two.xMin && one.yMin< two.yMax && two.yMax < one.yMax)||
					(one.yMin==two.yMax && one.xMin< two.xMin && two.xMin < one.xMax)||
					(one.yMin==two.yMax && one.xMin< two.xMax && two.xMax < one.xMax)||
					(one.xMin==two.xMax && one.yMin< two.yMin && two.yMin < one.yMax)||
					(one.xMin==two.xMax && one.yMin< two.yMax && two.yMax < one.yMax)||
					(one.yMax==two.yMin && one.xMin< two.xMax && two.xMax < one.xMax)||
					(one.yMax==two.yMin && one.xMin< two.xMin && two.xMin < one.xMax)) {
				System.out.println("b");
				continue;
			}else if((one.xMax>two.xMin && one.yMin< two.yMax) ||
					(two.xMax>one.xMin && two.yMin< one.yMax)||
					(one.xMax>two.xMin && one.yMax>two.yMin)||
					(two.xMax>one.xMin && two.yMax>one.yMin)||
					(one.xMin<two.xMax && one.yMin< two.yMax)||
					(two.xMin<one.xMax && two.yMin< one.yMax)||
					(one.xMin<two.xMax && one.yMax> two.yMin)||
					(two.xMin<one.xMax && two.yMax> one.yMin)){
				System.out.println("a");
			}
			
		}

	}

	static class Square{
		int xMin;
		int yMin;
		int xMax;
		int yMax;
		public Square(int xMin, int yMin, int xMax, int yMax) {
			super();
			this.xMin = xMin;
			this.yMin = yMin;
			this.xMax = xMax;
			this.yMax = yMax;
		}
		
	}
}
