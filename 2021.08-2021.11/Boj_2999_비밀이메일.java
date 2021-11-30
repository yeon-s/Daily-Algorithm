package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = str.length();
		int R,C=0;
		List<Integer> list = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			if(N%i==0) {
				list.add(i);
			}
		}
		
		if(list.size()%2==0) {
			C= list.get(list.size()/2);
			R = list.get((list.size()/2)-1);
		}else {
			R= list.get(list.size()/2);
			C = R;
		}

		char[][] letter = new char[R][C];
		
		char[] arr = str.toCharArray();
		
		int num=0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				letter[j][i] = arr[num++];
			}
		}
	
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(letter[i][j]);
			}
		}
		System.out.println(sb);
	}

}
