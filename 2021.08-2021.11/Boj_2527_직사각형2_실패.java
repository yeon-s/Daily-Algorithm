package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2527_직사각형2_실패 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 =Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 =Integer.parseInt(st.nextToken());
			int p2 =Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(p2==x1) {
				if(q2==y1 || y2 ==q1) {
					System.out.println("c");
					continue;
				}else if((q2>y1 && q2<q1) || (y2>y1 && y2<q1) || (q1>y2 && q1<q2) || (y1>y2 && y1<q2)){
					System.out.println("b");
					continue;
				}else {
					System.out.println("d");
					continue;
				}
			}else if((p2>x1 && p2<p1) || (x2>x1 && x2<p1)) {
				if(q2==y1 || y2==q1) {
					System.out.println("b");
					continue;
				}else if((q2>y1 && q2<q1) || (y2>y1 && y2<q1)) {
					System.out.println("a");
					continue;
				}else {
					System.out.println("d");
					continue;
				}
			}else if(x2==p1) {
				if(q2==y1 || q1==y2) {
					System.out.println("c");
					continue;
				}else if((q2>y1 && q2<q1) || (y2>y1 && y2<q1) ||(q1>y2 && q1<q2) || (y1>y2 && y1<q2)) {
					System.out.println("b");
					continue;
				}else {
					System.out.println("d");
					continue;
				}
			}else if((p1>x2 && p1<p2) || (x1>x2 && x1<p2)){
				if(q1==y2 || y1==q2) {
					System.out.println("b");
					continue;
				}else if((q1>y2 && q1<q2) || (y1>y2 && y1<q2)) {
					System.out.println("a");
					continue;
				}else {
					System.out.println("d");
					continue;
				}
			}else {
				System.out.println("d");
				continue;
			}
			
			
			
		}
	}
}
