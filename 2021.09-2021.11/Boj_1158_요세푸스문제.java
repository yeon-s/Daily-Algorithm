package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boj_1158_요세푸스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}

		int index=1;
		while(list.size()>0) {
			
			if(index%K==0) {
				result.add(list.get(0));
				list.remove(0);
			}else {
				list.addLast(list.remove(0));
			}
			
			index++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0;i<result.size();i++) {
			sb.append(result.get(i)+"").append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb+"");
	}

}
