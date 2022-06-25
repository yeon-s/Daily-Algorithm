package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj_5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new  StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			arr = arr.substring(1,arr.length()-1);
			if(n==0) {
				if(command.contains("D")) {
					sb.append("error"+"\n");
				}else {
					sb.append("[]"+"\n");
				}
				continue;
			}
			String[] arr2 = arr.split(",");
			
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i=0;i<arr2.length;i++) {
				deque.add(Integer.parseInt(arr2[i]));
			}
			boolean flag = false;
			boolean isContinue=false;
			
			for(int i=0;i<command.length();i++) {
				char c = command.charAt(i);
				if(c=='R') {
					flag=!flag;
				}else {
					if(deque.size()==0) {
						sb.append("error"+"\n");
						isContinue=true;
						break;
					}
					if(flag) {
						deque.removeLast();
					}else {
						deque.removeFirst();
					}
				}
			}
			
			if(isContinue) continue;
			if(deque.size()==0) {
				sb.append("[]"+"\n");
				continue;
			}
			sb.append("[");
			if(flag) {
				while(!deque.isEmpty()) {
					sb.append(deque.removeLast()+",");
				}
			}else {
				while(!deque.isEmpty()) {
					sb.append(deque.removeFirst()+",");
				}
			}
			sb.setLength(sb.length()-1);				
			sb.append("]"+"\n");
		}
		System.out.println(sb);

	}

}
