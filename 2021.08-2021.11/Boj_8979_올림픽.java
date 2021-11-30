package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_8979_올림픽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Country[] arr = new Country[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Country(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
		}

		Arrays.sort(arr);
		int index=0;
		for(int i=0;i<N;i++) {
			if(arr[i].num==K) {
				index=i;
			}
		}
		int result=1;
		int tmp=0;
		Country check = new Country(arr[0].num, arr[0].gold, arr[0].silver, arr[0].bronze);
		for(int i=1;i<=index;i++) {
			if(check.gold==arr[i].gold && check.silver==arr[i].silver && check.bronze==arr[i].bronze) {
				tmp++;
			}else {
				check = new Country(arr[i].num, arr[i].gold, arr[i].silver, arr[i].bronze);
				result += tmp;
				result++;
				tmp=0;
			}
		}
		
		System.out.println(result);
	}

	static class Country implements Comparable<Country>{
		int num;
		int gold;
		int silver;
		int bronze;
		public Country(int num,int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		@Override
		public int compareTo(Country o) {
			// TODO Auto-generated method stub
			if(this.gold>o.gold) {
				return -1;
			}else if(this.gold==o.gold) {
				if(this.silver>o.silver) {
					return -1;
				}else if(this.silver==o.silver) {
					if(this.bronze>o.bronze) {
						return -1;
					}
				}
			}
			return 1;
		}
		
	}
}
