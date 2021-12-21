package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_10867_중복빼고정렬하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		//입력 끝
		
		List<Integer> list = new ArrayList<>();
		for(int num: set) {
			list.add(num);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int num:list) {
			sb.append(num+" ");
		}
		System.out.println(sb);
		
	}

}
