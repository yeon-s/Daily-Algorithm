package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int[] number = new int[100001];
		number[arr[0]]++;
		int max = 1;
		int answer=0;
		List<Integer> maxList = new ArrayList<>();
		maxList.add(arr[0]);
		
		while(true) {
			
			if(max<=K) {
				answer = Math.max(answer, right-left+1);
				right++;
				if(right>=N) {
					break;
				}
				number[arr[right]]++;
			
				if(max==number[arr[right]]) {
					maxList.add(arr[right]);
				}else if(max<number[arr[right]]){
					max = number[arr[right]];
					maxList.clear();
					maxList.add(arr[right]);
				}
			}else {
				if(max==number[arr[left]]) {
					//나말고 다른 최대값 있는지 보기 있다면 최대값 그대로 없다면 최대값-=1;
					if(maxList.size()>1) {
						maxList.remove(maxList.indexOf(arr[left]));
					}else {
						max--;
					}
				}
				number[arr[left]]--;									
				left++;
			}
		}
		System.out.println(answer);
	}

}
