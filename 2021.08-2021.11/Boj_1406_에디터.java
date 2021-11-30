package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		int index =sb.length();
		
		int M = Integer.parseInt(br.readLine());
		LinkedList<String> list = new LinkedList<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
			if(list.getLast().equals("P")) {
				list.add(st.nextToken());
			}
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals("L")) {
				if(index>0) {
					index -=1;					
				}
			}else if(list.get(i).equals("R")) {
				if(index<sb.length()) {
					index +=1;					
				}
			}else if(list.get(i).equals("B")) {
				if(index>0) {
					sb.deleteCharAt(index-1);
					index--;
				}
			}else if(list.get(i).equals("P")) {
				sb.insert(index++, list.get(i+1));
				i +=1;
			}
		}
		System.out.println(sb);
	}

}
