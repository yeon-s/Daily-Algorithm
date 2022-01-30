package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_1339_단어수학2_그리디 {

	static Map<Character, Integer> map;
	static List<Integer> list;
	static int N;
	static String[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		list = new ArrayList<>();
		
		arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
			for(int j=0;j<arr[i].length();j++) {
				map.put(arr[i].charAt(j), map.getOrDefault(arr[i].charAt(j), 0)+(int)(Math.pow(10, arr[i].length()-j-1)));
			}
		}
		//입력 끝
		
		for(Character key:map.keySet()) {
			list.add(map.get(key));
		}
		
		Collections.sort(list,new Comparator<Integer>() {
			public int compare(Integer o1,Integer o2) {
				return o2-o1;
			}
		});
		
		int sum =0;
		int num=9;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i)*num;
			num--;
		}
	
		System.out.println(sum);
	}

}
