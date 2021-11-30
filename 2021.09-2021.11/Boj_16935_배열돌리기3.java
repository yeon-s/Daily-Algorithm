package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16935_배열돌리기3 {

	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		int[] cmd = new int[R];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		int banN = N/2;
		int banM = M/2;
		
		boolean flag = false;
		int tempN = N;
		int tempM=M;
		
		for(int t=0;t<R;t++) {
			int temp = cmd[t];
			
			
			int[][] map2 = new int[N][M];
			
			switch(temp) {
			case 1:
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map2[i][j] = map[N-1-i][j];
					}
				}
				break;
			case 2:
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map2[i][j] = map[i][M-1-j];
					}
				}
				break;
			case 3:
				map2 = new int[M][N];
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						map2[i][j] = map[N-1-j][i];
					}
				}
				tempN = N;
				tempM=M;
				N=tempM;
				M=tempN;
				flag=true;
				break;
			case 4:
				map2 = new int[M][N];
				for(int i=0;i<M;i++) {
					for(int j=0;j<N;j++) {
						map2[i][j] = map[j][M-1-i];
					}
				}
				tempN = N;
				tempM=M;
				N=tempM;
				M=tempN;
				flag=true;
				break;
			case 5:
				banN = N/2;
				banM = M/2;
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(i<banN && j<banM) {
							map2[i][j] = map[i+banN][j];
						}else if(i<banN && j>=banM) {
							map2[i][j] = map[i][j-banM];
						}else if(i>=banN && j<banM) {
							map2[i][j] = map[i][j+banM];
						}else if(i>=banN && j>=banM) {
							map2[i][j] = map[i-banN][j];
						}
					}
				}
				break;
			case 6:
				banN = N/2;
				banM = M/2;
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						if(i<banN && j<banM) {
							map2[i][j] = map[i][j+banM];
						}else if(i<banN && j>=banM) {
							map2[i][j] = map[i+banN][j];
						}else if(i>=banN && j<banM) {
							map2[i][j] = map[i-banN][j];
						}else if(i>=banN && j>=banM) {
							map2[i][j] = map[i][j-banM];
						}
					}
				}
				break;
			}
			
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = map2[i][j];
				}
			}				
			
			
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
