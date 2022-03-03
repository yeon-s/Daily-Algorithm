package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_1302_베스트셀러 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		int max= 0;
		for(String key: map.keySet()) {
			if(max<map.get(key)) {
				max = map.get(key);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String key:map.keySet()) {
			if(map.get(key)==max) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}
