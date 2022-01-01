package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj_4358_생태학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<>();
		
		int all = 0;
		
		while(true) {
			String tree = br.readLine();
			if(tree==null || tree.length()==0) {
				break;
			}
			all++;
			if(map.containsKey(tree)) {
				int num = map.get(tree);
				map.put(tree, num+1);
			}else {
				map.put(tree, 1);				
			}
		}
		
		List<Tree> list = new ArrayList<>();
		
		for(String key: map.keySet()) {
			list.add(new Tree(key, map.get(key)));
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Tree t:list) {
			sb.append(t.name+" "+String.format("%.4f", (double)(t.num*100.0)/all)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Tree implements Comparable<Tree>{
		String name;
		int num;
		public Tree(String name, int num) {
			super();
			this.name = name;
			this.num = num;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(o.name);
		}
		
	}

}
