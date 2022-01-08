package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1057_토너먼트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int im = Integer.parseInt(st.nextToken());
		
		int cnt=1;
		kim+=1;
		im+=1;
		
		
		while(N/2>0) {
			if(Math.abs(kim-im)==1 && (kim/2)-(im/2)==0) {
				break;
			}
			
			kim /=2;
			im /=2;
			kim+=1;
			im+=1;
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
