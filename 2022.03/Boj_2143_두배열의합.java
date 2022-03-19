package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


//음수를 생각했어야지!!!!!
public class Boj_2143_두배열의합 {

	static long T;
	static int n;
	static int m;
	static int[] arrA;
	static int[] arrB;
	static Map<Long, Integer> mapA;
	static Map<Long, Integer> mapB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Long.parseLong(br.readLine());
		n = Integer.parseInt(br.readLine());
		arrA = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arrB = new int[m];
		for(int i=0;i<m;i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		mapA = new HashMap<>();
		mapB = new HashMap<>();

		put(n,arrA,mapA);
		put(m,arrB,mapB);
	
		long answer=0;
		for(long i:mapB.keySet()) {
			long cnt = mapB.get(i);
			long dest = T-i;
			
			if(!mapA.containsKey(dest)) {
				continue;
			}
			long num = mapA.get(dest);
			answer+=(cnt*num);
		}
		System.out.println(answer);
	}
	
	static void put(int n,int[] arr,Map<Long, Integer> map) {
		for(int i=0;i<n;i++) {
			long sum=0;
			
			for(int j=i;j<n;j++) {
				sum+=arr[j];
				map.put(sum, map.getOrDefault(sum,0)+1);
			}
		}
	}

}
