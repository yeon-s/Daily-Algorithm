package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			LinkedList<print> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(new print(i, Integer.parseInt(st.nextToken())));
			}
			
			int count=0;
			while(true) {
				int currentImportance = list.get(0).importance;
				boolean flag = true;
				for(int i=1,size=list.size();i<size;i++) {
					int importance = list.get(i).importance;
					if(importance>currentImportance) {
						flag=false;
						break;
					}
				}
				if(!flag) {
					list.addLast(list.removeFirst());
				}else {
					int index = list.removeFirst().index;
					count++;
					if(index==M) {
						break;
					}
				}
				
			}
			System.out.println(count);
		}
	}
	
	static class print{
		int index;
		int importance;
		public print(int index, int importance) {
			super();
			this.index = index;
			this.importance = importance;
		}
		
	}

}
