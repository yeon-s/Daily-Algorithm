package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1228_암호문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T =10;
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				list.add(st.nextToken());
			}
			
			int cmd = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<cmd;i++) {
				String l = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for(int j=index;j<index+num;j++) {
					list.add(j, st.nextToken());
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)+" ");
			}
			
			System.out.println("#"+tc+" "+sb);
		}

	}

}
