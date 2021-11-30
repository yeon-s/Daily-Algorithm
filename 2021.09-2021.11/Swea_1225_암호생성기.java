package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1225_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int T = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0;i<8;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			//한사이클
			boolean flag = false;
			while(true) {
				
				for(int i=1;i<=5;i++) {
					int num = queue.poll();
					if(num-i<=0) {
						queue.offer(0);
						flag = true;
						break;
					}
					queue.offer(num-i);
				}
				if(flag) {
					break;
				}
			}
			System.out.print("#"+tc+" ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}

	}

}
