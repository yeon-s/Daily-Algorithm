package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Boj_5052_전화번호목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {

			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int i=0;i<n;i++) {
				arr[i] = br.readLine();
			}
			
			for(int i=0;i<n;i++) {
				String str = arr[i];
				for(int j=1;j<str.length();j++) {
					map.put(str.substring(0,j), 1);
				}
			}
			
			boolean flag=false;
			for(int i=0;i<n;i++) {
				if(map.containsKey(arr[i])) {
					flag=true;
					sb.append("NO"+"\n");
					break;
				}
			}
			if(!flag) {
				sb.append("YES"+"\n");
			}
		}
		System.out.println(sb);
		
	}

}
