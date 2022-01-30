package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1107_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int want = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		if(m!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		//입력 끝
		
		int answer=1000000;
		int cnt = Math.abs(100-want);
		answer = Math.min(cnt, answer);
		
		for(int i=0;i<=1000000;i++) {
			String num = (i+"");
			boolean flag=false;
			for(int j=0;j<list.size();j++) {
				if(num.contains(list.get(j)+"")) {
					flag=true;
					break;
				}
			}
			
			if(flag) {		//만들수 없는 숫자 현재채널에서 +,-이동만가능
				continue;
			}
			
			int size = num.length();
			cnt = Math.abs(want-i);
			answer = Math.min(answer, cnt+size);
			
		}
		
		System.out.println(answer);
		
		

	}

}
