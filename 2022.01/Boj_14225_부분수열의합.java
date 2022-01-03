package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14225_부분수열의합 {

	static int N;
	static int[] arr;
	static int sum;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		sum=0;
		list = new ArrayList<>();

		subset(0);
		Collections.sort(list);
		int num=1;
		for(int i=1;i<list.size();i++) {
			int check = list.get(i);
			if(check>num) {
				break;
			}else if(check==num){
				num++;
			}else {
				continue;
			}
		}
		
		System.out.println(num);
	}
	
	static void subset(int cnt) {
		if(cnt==N) {

			list.add(sum);

			return;
		}
		
		sum+=arr[cnt];
		subset(cnt+1);
		sum-=arr[cnt];
		subset(cnt+1);
	}

}
