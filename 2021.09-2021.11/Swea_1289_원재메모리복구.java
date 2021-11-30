package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Swea_1289_원재메모리복구 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = br.readLine();
			
			int N = str.length();
			boolean[] arr = new boolean[N];
			for(int i=0;i<N;i++) {
				if(str.substring(i, i+1).equals("1")){
					arr[i] = true;
				}
			}
			int result=0;
			boolean[] arr2 = new boolean[N];
			for(int i=0;i<N;i++) {
				if(arr[i] && !arr2[i]) {
					for(int j=i;j<N;j++) {
						arr2[j] = true;
					}
					result++;
				}else if(!arr[i] && arr2[i]) {
					for(int j=i;j<N;j++) {
						arr2[j] = false;
					}
					result++;
				}
			}
			System.out.println("#"+tc+" "+result);
		}

	}

}
