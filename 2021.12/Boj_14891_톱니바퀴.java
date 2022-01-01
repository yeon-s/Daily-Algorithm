package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_14891_톱니바퀴 {

	static LinkedList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new LinkedList[4];
		for(int i=0;i<4;i++) {
			arr[i] = new LinkedList<>();
			String str = br.readLine();
			for(int j=0;j<8;j++) {
				arr[i].add((int)(str.charAt(j)-'0'));
			}
		}
		
		int[] rotate = new int[4];
		
		int K = Integer.parseInt(br.readLine());
		while(K-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int direction = Integer.parseInt(st.nextToken());
			
			Arrays.fill(rotate, 0);
			//왼쪽 오른쪽 각각 극 다른지 확인하고 rotate배열에 회전방향 저장
			rotate[num] = direction;
			
			int temp = direction;
			if(num>0) {		//왼쪽보기
				for(int i=num;i>0;i--) {
					if(arr[i].get(6)!= arr[i-1].get(2)) {
						temp *=-1;
						rotate[i-1]= temp;
					}else {
						break;
					}
				}
			}
			temp = direction;
			if(num<3) {		//오른쪽보기
				for(int i=num;i<3;i++) {
					if(arr[i].get(2)!= arr[i+1].get(6)) {
						temp *=-1;
						rotate[i+1]= temp;
					}else {
						break;
					}
				}
			}
			
			//회전정보대로 회전
			for(int i=0;i<4;i++) {
				if(rotate[i]==1) {
					rotation(i);
				}else if(rotate[i]==-1) {
					banRotation(i);
				}
			}
		}
		
		int score = 0;
		for(int i=0;i<4;i++) {
			score+=arr[i].get(0)*Math.pow(2, i);
		}
		System.out.println(score);
	}
	
	static void rotation(int num) {
		arr[num].addFirst(arr[num].removeLast());
	}
	
	static void banRotation(int num) {
		arr[num].addLast(arr[num].removeFirst());
	}

}
