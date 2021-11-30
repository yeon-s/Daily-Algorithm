package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj_2810_컵홀더2_실패 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		List<Character> list = new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}

		Queue<Character> queue = new LinkedList<Character>();
		for(int i=0;i<N;i++) {
			queue.offer(list.get(i));
		}
		
		int count=0;
		while(!queue.isEmpty()) {
			char c = queue.poll();
			if(c=='S') {
				continue;
			}else {
				queue.poll();
				count++;
			}
		}
		
		int result =N-count;
		if(list.get(list.size()-1)=='L') {
			result = result+1;
		}else if(list.get(list.size()-1)=='S' && list.get(list.size()-2)=='L') {
			result = result+1;
		}
		System.out.println(result);
	}

}
