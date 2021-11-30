package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_6808_규영이와인영이의카드게임 {
	
	static boolean[] isSelected;
	static int[] result;
	static int[] in;
	static int win;
	static int lose;
	static int[] kyu;
	static int kScore;
	static int iScore;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			kyu = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				
			}
			
			in = new int[9];
			int index=0;
			for(int i=1;i<=18;i++) {
				boolean check = false;
				for(int j=0;j<9;j++) {
					if(i==kyu[j]) {
						check=true;
						break;
					}
				}
				if(!check) {
					in[index++]=i;
				}
				
			}
			
			isSelected = new boolean[9];
			result = new int[9];
			win =0;
			lose=0;
			perm(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	
	static void perm(int cnt) {
		if(cnt==9) {
			int kScore =0;
			int iScore = 0;
			for(int i=0;i<9;i++) {
				if(result[i]>kyu[i]) {
					iScore += result[i]+kyu[i];
				}else {
					kScore += result[i]+kyu[i];
				}
			}
			
			if(iScore>kScore) {
				lose++;
			}else if(kScore>iScore) {
				win++;
			}
			
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(isSelected[i]) {
				continue;
			}
			result[cnt] = in[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i]=false;
		}
	}
}
