package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9019_DSLR {

	static int B;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		sb= new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			visited = new boolean[10000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String A = st.nextToken();
			B = Integer.parseInt(st.nextToken());
			
			bfs(Integer.parseInt(A));
		}
		System.out.println(sb);
		
	}
	
	static void bfs(int start) {
		Queue<Number> queue = new LinkedList<>();
		queue.offer(new Number(start, ""));
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			Number current = queue.poll();
			
			if(current.what==B) {
				sb.append(current.answer+"\n");
				return;
			}
			
			int num= current.what;
				
			int temp=num;
			temp*=2;
			if(temp>=10000) {
				temp=temp%10000;
			}
			if(!visited[temp]) {
				queue.offer(new Number(temp, current.answer+"D"));
				visited[temp]=true;
			}
		
			temp=num;
			if(temp>0) {
				temp-=1;
			}else {
				temp=9999;
			}
			if(!visited[temp]) {
				queue.offer(new Number(temp, current.answer+"S"));
				visited[temp]=true;
			}
	
			temp=num;
			String str = check(temp);
			str = str+str.charAt(0);
			str=str.substring(1,5);
			if(!visited[Integer.parseInt(str)]) {
				queue.offer(new Number(Integer.parseInt(str), current.answer+"L"));
				visited[Integer.parseInt(str)]=true;
			}
		
			temp=num;
			str = check(temp);
			str=str.charAt(3)+str;
			str=str.substring(0,4);
			if(!visited[Integer.parseInt(str)]) {
				queue.offer(new Number(Integer.parseInt(str), current.answer+"R"));
				visited[Integer.parseInt(str)]=true;
			}
		
	
	
		}
	}
	
//	static void dfs(String current,String answer) {
//		if(current.equals(B)) {
//			//answer 알파벳으로 변환하고 스트링빌더에 추가
//			return;
//		}
//		int num= Integer.parseInt(current);
//		visited[num]=true;
//		
//		for(int d=0;d<4;d++) {
//			if(d==0) {
//				num*=2;
//				if(num>=10000) {
//					num=num%10000;
//				}
//				String str =check(num);
//				dfs(str,answer+"D");
//			}else if(d==1) {
//				if(num>0) {
//					num-=1;
//				}else {
//					num=9999;
//				}
//				String str = check(num);
//				dfs(str,answer+"S");
//			}else if(d==2) {
//				String str = check(num);
//				str = str+str.charAt(0);
//				str=str.substring(1,5);
//				dfs(str,answer+"L");
//			}else if(d==3) {
//				String str = check(num);
//				str=str.charAt(3)+str;
//				str=str.substring(0,4);
//				dfs(str,answer+"R");
//			}
//		}
//	}
	
	static class Number{
		int what;
		String answer;
		public Number(int what, String answer) {
			super();
			this.what = what;
			this.answer = answer;
		}
		
	}
	
	static String check(int num) {
		String str="";
		if(num/1000==0) {
			str+="0";
		}
		if(num/100==0) {
			str+="0";
		}
		if(num/10==0) {
			str+="0";
		}
		str+=(num+"");
		return str;
		
		
	}

}
