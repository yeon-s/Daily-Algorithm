package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1759_암호만들기 {

	static int L;
	static int C;
	static char[] arr;
	static char[] result;
	static String moeum = "aeiou";
	static List<String> answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr= new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		//입력 끝
		result = new char[L];
		answer = new ArrayList<>();

		comb(0,0);
		Collections.sort(answer);
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));			
		}
	}
	
	static void comb(int target,int cnt) {
		if(cnt==L) {
			int num = 0;		//모음개수세기
			for(int i=0;i<L;i++) {
				if(moeum.contains(result[i]+"")) {
					num++;
				}
			}
			
			if(num==0) {		//모음없으면 return
				return;
			}
			if(L-num<2) {		//자음 2개 미만이면 return
				return;
			}
			
			char[] sort = new char[L];		//정렬하기 위해 복사
			for(int i=0;i<L;i++) {
				sort[i] = result[i];
			}
			
			Arrays.sort(sort);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<L;i++) {
				sb.append(sort[i]);
			}
			
			answer.add(sb+"");
			return;
		}
		
		if(target==C) {
			return;
		}
		
		result[cnt] = arr[target];
		comb(target+1,cnt+1);
		
		comb(target+1,cnt);
		
		
	}
	

}
