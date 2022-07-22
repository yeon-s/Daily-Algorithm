package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_20437_문자열게임2 {
	static int K, length, length2;
	static String str;
	static Map<Character, Integer> map;
	static List<Character> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			str = br.readLine();
			K = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			list = new ArrayList<>();
			int temp = check();
			int temp2 = check3();
			
			if(temp==100000) sb.append(-1+"\n");
			else sb.append(length+" "+temp2+"\n");
		}
		System.out.println(sb);
		
	}
	
	static int check() {
		int size= str.length();
		
		int left = 0;
		int right = 0; 
		map.put(str.charAt(0),1);
		
		length = 99999;
		while(right<size) {
			
			if(check2()) {
				length = Math.min(length,right-left);
				char c = str.charAt(left);
				if(map.get(c)>0) map.put(c, map.get(c)-1);
				left++;
			}else {
				right++;
				if(right>=size) break;
				char c =str.charAt(right);
				map.put(c, map.getOrDefault(c, 0)+1);
			}
		}
		length = length+1;
		return length;
	}
	
	static boolean check2() {
		list.clear();
		for(char c : map.keySet()) {
			if(map.get(c)==K) {
				list.add(c);
			}
		}
		if(list.size()!=0) return true;
		return false;
	}
	
	static int check3() {
		int size= str.length();
		
		int cnt=0;
		
		List<Integer> indexList = new ArrayList<>();
		
		for(int i=0;i<26;i++) {
			char dest = (char)('a'+i);
			
			indexList.clear();
			
			for(int j=0;j<size;j++) {
				if(str.charAt(j)==dest) {
					indexList.add(j);
				}
			}
			
			if(indexList.size()<K ) continue;
			
			//슬라이딩 윈도우
			int temp=0;
			for(int j=0;j<=indexList.size()-K;j++) {
				temp = Math.max(temp, indexList.get(j+K-1)-indexList.get(j));
			}
			
			cnt = Math.max(cnt, temp);
		}
		
		return cnt+1;
	}
}
