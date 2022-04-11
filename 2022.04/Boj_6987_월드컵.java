package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6987_월드컵 {

	static int[][] result;
	static boolean flag;
	static int[][] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int k=0;k<4;k++) {
			
			temp = new int[6][3];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean early = false;
			int sum=0;
			for(int i=0;i<6;i++) {
				int sum2=0;
				for(int j=0;j<3;j++) {
					temp[i][j] = Integer.parseInt(st.nextToken());
					sum2+=temp[i][j];
					sum+=temp[i][j];
				}
//				if(sum2!=5) {
//					early=true;
//				}
			}
			if(sum!=30) {
				early=true;
			}
			if(early) {
				System.out.print(0+" ");
				continue;
			}
			
			result = new int[6][3];
			flag=false;
			comb(0,1);
			
			if(flag) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
		}

	}
	
	static void comb(int cnt,int i) {
		if(flag) {
			return;
		}
		if(cnt==6) {
			
//			boolean check = true;
//			loop : for(int i=0;i<6;i++) {
//				for(int j=0;j<3;j++) {
//					if(temp[i][j]!=result[i][j]) {
//						check=false;
//						break loop;
//					}
//				}
//			}
//			if(check) {
//				flag=true;
//			}
			flag=true;
			return;
		}else if(i==6) {
			comb(cnt+1,cnt+2);
		}else {
			
			//for(int i=start;i<6;i++) {
				//승
				temp[cnt][0]--;
				temp[i][2]--;
				if(temp[cnt][0]>=0 && temp[i][2]>=0) comb(cnt,i+1);
				temp[cnt][0]++;
				temp[i][2]++;
				//무
				temp[cnt][1]--;
				temp[i][1]--;
				if(temp[cnt][1]>=0 && temp[i][1]>=0) comb(cnt,i+1);
				temp[cnt][1]++;
				temp[i][1]++;
				//패
				temp[cnt][2]--;
				temp[i][0]--;
				if(temp[cnt][2]>=0 && temp[i][0]>=0) comb(cnt,i+1);
				temp[cnt][2]++;
				temp[i][0]++;
			//}
		}
		
		//comb(cnt+1,cnt+2);
	}

}
