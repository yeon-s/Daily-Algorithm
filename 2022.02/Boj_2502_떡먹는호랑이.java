package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2502_떡먹는호랑이 {

	static int[] dA;
	static int[] dB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dA = new int[D+1];
		dB = new int[D+1];
		dA[0] = 0;
		dB[0] = 0;
		dA[1] = 1;
		dB[1] = 0;
		dA[2] = 0;
		dB[2] = 1;
		
		for(int i=3;i<=D;i++) {
			dA[i] = dA[i-1]+dA[i-2];
			dB[i] = dB[i-1]+dB[i-2];
		}
		
		int A = 1;
		int B = 1;
		
		while(true) {
			int num =(dA[D]*A)+(dB[D]*B); 
			if( num==K ) {
				break;
			}
			
			if(num>K) {
				B--;
				A++;
			}else {
				B++;
			}
		}
		
		System.out.println(A+"\n"+B);
		
		
	}
	
	

}
