package repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5212_지구온난화 {

	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int R,C;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//잠기는 곳 체크
		boolean[][] checked = new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(check(i,j)) checked[i][j] = true;
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(checked[i][j]) map[i][j]='.';
			}
		}
		
		int rMax=0,rMin=R,cMax=0,cMin=C;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='X') {
					rMax = Math.max(i, rMax);
					rMin = Math.min(i, rMin);
					cMax = Math.max(j, cMax);
					cMin = Math.min(j, cMin);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=rMin;i<=rMax;i++) {
			for(int j=cMin;j<=cMax;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static boolean check(int nowi,int nowj) {
		
		int cnt = 0;
		for(int d=0;d<4;d++) {
			int nexti = nowi+di[d];
			int nextj = nowj+dj[d];
			
			if(nexti<0 || nextj<0 || nexti>=R || nextj>=C || map[nexti][nextj]=='.') {
				cnt++;
				continue;
			}
		}
		if(cnt>=3) return true;
		return false;
	}

}
