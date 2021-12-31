package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set1 = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			set1.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		int num=0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(set1.contains(str)) {
				list.add(str);
				num++;
			}
		}
		Collections.sort(list);
		for(String s:list) {
			sb.append(s).append("\n");
		}
		System.out.println(num);
		System.out.println(sb);

	}

}
