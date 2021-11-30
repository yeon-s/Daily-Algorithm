package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_2810_컵홀더_실패 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		List<Character> list = new ArrayList<Character>();
		list.add('*');
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)=='S') {
				list.add('S');
				list.add('*');
			}else {
				list.add('L');
				list.add('L');
				list.add('*');
				i = i+1;
			}
		}
		
		list.remove(list.size()-1);
		list.remove(list.size()-1);
		
		if(list.size()<2) {
			System.out.println(1);
			return;
		}
		
		int count =0;
		if(list.size()%2==0) {
			for(int i=0;i<list.size();i++) {
				char one = list.get(i);
				char two = list.get(i+1);
				if(one !='*' && two!='*') {
					count +=1;
					i=i+1;
				}
				i=i+1;
			}			
		}else {
			for(int i=0;i<list.size();i++) {
				char one = list.get(i);
				char two = list.get(i+1);
				if(one !='*' && two!='*') {
					count +=1;
					i=i+1;
				}
				i=i+1;
			}		
			if(list.get(list.size()-1)=='L' || list.get(list.size()-1)=='S') {
				count +=1;
			}else if(list.get(list.size()-1)=='*' && list.get(list.size()-2)=='L') {
				count -=1;
			}
		}
		
		System.out.println(N-count);
		

	}

}
