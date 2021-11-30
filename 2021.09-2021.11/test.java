package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

	public static void main(String[] args) {
		
		List<Point> list = new ArrayList<>();
		
		list.add(new Point(1, 1));
		list.add(new Point(2, 2));
		list.add(new Point(5, 5));
		list.add(new Point(3, 2));
		list.add(new Point(1, 0));
		
		Collections.sort(list);
		
		for(Point p : list) {
			System.out.print(p.i+" "+ p.j);
			System.out.println();
		}

	}

	static class Point implements Comparable<Point>{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Point o) {
			if(this.i>o.i) {
				return 1;
			}else if(this.i==o.i){
				if(this.j>o.j) {
					return 1;
				}
			}
			return -1;
		}
		
	}
}
