package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_10825_국영수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Student> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll().name+"\n");
		}
		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student>{
		String name;
		int korean;
		int english;
		int math;
		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		@Override
		public int compareTo(Student o) {
			if(this.korean==o.korean) {
				if(this.english==o.english) {
					if(this.math==o.math) {
						return this.name.compareTo(o.name);
					}
					return o.math-this.math;
				}
				return this.english-o.english;
			}
			return o.korean-this.korean;
		}
		
	}

}
