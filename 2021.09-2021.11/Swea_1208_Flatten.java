package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int dump = Integer.parseInt(br.readLine());
			
			int[] arr = new int[101];
			int max = 0;
			int min = 1000;
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num] +=1;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			
			while(dump-->0) {
				if(max-min<=1) {
					break;
				}
				arr[max]--;
				arr[max-1]++;
				if(arr[max]==0) {
					max-=1;
				}
				
				arr[min]--;
				arr[min + 1]++;
				if(arr[min]==0) {
					min+=1;
				}
			}
			
			System.out.println("#"+tc+" "+(max-min));
		}
	}

}
