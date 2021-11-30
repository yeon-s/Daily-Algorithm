package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(N%2==0) {
				for(int i=0;i<N/2;i++) {
					queue1.offer(st.nextToken());
				}
			}else {
				for(int i=0;i<N/2+1;i++) {
					queue1.offer(st.nextToken());
				}
			}
			for(int i=0;i<N/2;i++) {
				queue2.offer(st.nextToken());
			}
			
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<N/2;i++) {
				sb.append(queue1.poll()).append(" ").append(queue2.poll()+" ");
			}
			if(N%2==1) {
				sb.append(queue1.poll());
			}
			System.out.println("#"+tc+" "+sb);
		}
	}

}
