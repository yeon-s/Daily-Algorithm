package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N+1];
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			map.put(str, i);
			arr[i] = str;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			String str= br.readLine();
			
			char c = str.charAt(0);
			if((c-'A'>=0 && c-'Z'<=0) || (c-'a'>=0 && c-'z'<=0) ) {
				sb.append(map.get(str)+"\n");
			}else {
				sb.append(arr[Integer.parseInt(str)]+"\n");
			}
		}
		System.out.println(sb);

	}

}
