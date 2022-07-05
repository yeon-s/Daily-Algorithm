package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1049_기타줄 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Brand[] arr = new Brand[M];
		int minP=1000;
		int minO=1000;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			minP = Math.min(p, minP);
			minO = Math.min(o, minO);
			arr[i] = new Brand(p,o);
		}
		
		if(minP<minO*6) {
			System.out.println(Math.min((int)(Math.ceil((double)N/6))*minP, ((N/6)*minP)+((N%6)*minO)));
		}else {
			System.out.println(minO*N);
		}
		
		

	}
	
	static class Brand{
		int pack;
		int one;
		public Brand(int pack, int one) {
			super();
			this.pack = pack;
			this.one = one;
		}
		
	}

}
