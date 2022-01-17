package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			deque.clear();
			String command = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			if(n==0) {
				if(command.contains("D")) {
					sb.append("error"+"\n");
					continue;
				}
				else {
					sb.append("[]"+"\n");
					continue;
				}
			}
			
			str = str.substring(1,str.length()-1);
			String[] arr = str.split(",");
			
			for(int i=0;i<arr.length;i++) {
				deque.add(Integer.parseInt(arr[i]));
			}
			
			boolean flag=true;
			boolean check=false;
			for(int i=0;i<command.length();i++) {
				if(command.charAt(i)=='R') {
					flag = !flag;
					continue;
				}
				if(deque.isEmpty()) {
					check=true;
					break;
				}
				if(flag) {
					deque.poll();
				}else {
					deque.pollLast();
				}
			}
			if(check) {
				sb.append("error"+"\n");
				continue;
			}
			
			sb.append("[");
			if(deque.isEmpty()) {
				sb.append("]"+"\n");
				continue;
			}
			while(!deque.isEmpty()) {
				if(flag) {
					sb.append(deque.poll()+",");					
				}else {
					sb.append(deque.pollLast()+",");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("]").append("\n");
		}
		
		System.out.println(sb);
	}

}
