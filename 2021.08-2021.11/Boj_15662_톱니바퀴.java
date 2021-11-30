package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_15662_톱니바퀴 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		LinkedList<Integer>[] arr = new LinkedList[T+1];
		
		for(int i=1;i<=T;i++) {
			arr[i] = new LinkedList<>();
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				arr[i].add(Integer.parseInt(str.substring(j,j+1)));
			}
		}
		//입력 끝
		

		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			int[] rotate = new int[T+1]; 	//회전정보 저장할 배열
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			rotate[num] = d;
			
			//뒤에있는 애들 보기
			for(int j=num;j>1;j--) {
				if(arr[j].get(6)!=arr[j-1].get(2)) {
					rotate[j-1] = rotate[j]*-1;
				}else {
					break;
				}
			}
			//앞에 있는 애들 보기
			for(int j=num;j<T;j++) {
				if(arr[j].get(2)!=arr[j+1].get(6)) {
					rotate[j+1] = rotate[j]*-1;
				}else {
					break;
				}
			}
			
			for(int j=1;j<=T;j++) {
				if(rotate[j]==1) {
					int ns = arr[j].remove(7);
					arr[j].addFirst(ns);
				}else if(rotate[j]==-1) {
					int ns = arr[j].remove(0);
					arr[j].addLast(ns);
				}
			}
			
		}
		int result=0;
		for(int i=1;i<=T;i++) {
			if(arr[i].get(0)==1) {
				result++;
			}
		}
		System.out.println(result);

	}

}
