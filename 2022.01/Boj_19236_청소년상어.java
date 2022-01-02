package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19236_청소년상어 {

	static int[] di = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,0,-1,-1,-1,0,1,1,1};
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[4][4];  	//0부터
		Fish[] arr = new Fish[17];		//1부터
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j]=num;
				arr[num] = new Fish(i, j, Integer.parseInt(st.nextToken()));
			}
		}
		//입력 끝
		
		max=0;
		
		arr[0] = new Fish(0, 0, 0);
		int first = map[0][0];
		arr[0].d = arr[map[0][0]].d;
		arr[map[0][0]]=null;
		map[0][0]=0; 		//상어 입장

		dfs(first,map,arr);
		System.out.println(max);
			
	}
	
	static void dfs(int sum,int[][] copyMap, Fish[] copyArr) {
		fishMove(copyMap,copyArr);
		
		//상어 이동
		int sharki = copyArr[0].i;			//초기상어정보
		int sharkj = copyArr[0].j;			//초기상어정보
		int sharkD = copyArr[0].d;			//초기상어정보
		int tempi = copyArr[0].i;			//임시(백트래킹해서 오면 바뀌어야 하기 때문)
		int tempj = copyArr[0].j;
		while(true) {
			int nexti = tempi+di[sharkD];
			int nextj = tempj+dj[sharkD];
			
			if(nexti<0 || nextj<0 || nexti>=4 || nextj>=4) {		//더이상 갈 곳 없음 집가자
				//return??
				max= Math.max(max, sum);
				return;
			}
			
			if(copyMap[nexti][nextj]<0) {		//물고기 없음 다음 갈 수 있는 곳으로 가자
				tempi=nexti;
				tempj=nextj;
				continue;
			}
			
			//잡아먹고 그쪽 평행세계로 가서 너의 꿈을 펼쳐봐
			copyMap[copyArr[0].i][copyArr[0].j]=-1;			//원래 상어 있던 자리는 공백
			copyArr[0].i=nexti;								//상어는 이동한 위치로 갱신
			copyArr[0].j=nextj;								//
			int d=copyArr[copyMap[nexti][nextj]].d;			//상어한테 먹힌 애의 방향
			copyArr[0].d = d;								//상어 방향 갱신
			int what = copyMap[nexti][nextj];				//상어한테 먹힌 애 번호
			copyArr[what]=null;								//상어한테 먹힌애는 없애줌
			copyMap[nexti][nextj]=0;						//상어이동
			
			//복사한걸로 평행세계보내기
			int[][] copyMap2 = new int[4][4];
			Fish[] copyArr2 = new Fish[17];
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					copyMap2[i][j] = copyMap[i][j];
				}
			}
			
			for(int i=1;i<17;i++) {
				if(copyArr[i]==null) {
					copyArr2[i]=null;
					continue;
				}
				copyArr2[i] = new Fish(copyArr[i].i, copyArr[i].j, copyArr[i].d);
			}
			copyArr2[0] = new Fish(nexti, nextj, d);		//상어도 만들어줘야지
			
			dfs(sum+what,copyMap2,copyArr2);				//꿈을 펼쳐봐
			
			//원래상태로 돌려놓기
			copyArr[what] = new Fish(nexti, nextj, d);		//먹혔던애 데려오기
			copyMap[nexti][nextj]=what;						//
			copyMap[sharki][sharkj]=0;						//원래 상어 있던 자리로
			copyArr[0].i=sharki;							//원래 상어 상태로 돌려줌
			copyArr[0].j=sharkj;
			copyArr[0].d=sharkD;
			
			tempi=nexti;
			tempj=nextj;
		}
	}
	
	static void fishMove(int[][] copyMap, Fish[] copyArr) {
		//번호 작은 애부터 순서대로 
		//물고기 이동
		for(int i=1;i<17;i++) {
			if(copyArr[i]==null) {
				continue;
			}
			
			int d = copyArr[i].d;
			int eight = 0;
			int nexti;
			int nextj;
			//이동할 수 있는 방향 될때까지 45도 반시계회전    한바퀴 돌아도 갈곳없으면 이동안함
			while(true) {
				if(eight==8) {
					break;
				}
				nexti = copyArr[i].i+di[d];
				nextj = copyArr[i].j+dj[d];				
				
				if(nexti<0 || nextj<0 || nexti>=4 || nextj>=4 || copyMap[nexti][nextj]==0) {
					d++;
					eight++;
					if(d>8) {
						d=1;
					}
					continue;
				}
			
				copyArr[i].d = d;
				//가는 곳이 물고기면 배열에 있는 물고기 위치정보 둘다 바꿔주기
				if(copyMap[nexti][nextj]>0) {
					int num = copyMap[nexti][nextj];
					copyMap[copyArr[i].i][copyArr[i].j]=num;
					copyArr[num].i=copyArr[i].i;
					copyArr[num].j=copyArr[i].j;
					copyMap[nexti][nextj] = i;	
					copyArr[i].i=nexti;
					copyArr[i].j=nextj;	
				}else {			//빈칸이면 걍 이동하고 얘만 바꿔
					copyMap[nexti][nextj] = i;	
					copyMap[copyArr[i].i][copyArr[i].j]=-1;
					copyArr[i].i=nexti;
					copyArr[i].j=nextj;					
				}
				
				break;
			}
			
		}
	}
	
	static class Fish{
		int i;
		int j;
		int d;
		public Fish(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}

}
