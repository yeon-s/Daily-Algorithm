package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_21611_마법사상어와블리자드2_실패 {

	static int[] deli= {0,1,0,-1};
	static int[] delj= {1,0,-1,0};
	
	static int[] di= {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());			//N의 크기
		int M = Integer.parseInt(st.nextToken());			//마법 시전 횟수
		
		int[][] map = new int[N][N];		//구슬번호 들어있는 배열
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());			//맵에 구슬번호 담기
			}
		}
		//입력 끝
		
		int[][] number = new int[N][N];		//숫자정보 담는 배열(인덱스로 활용예정)
		int num = (N*N)-1;
		int nowi=0;
		int nowj=0;
		int d=0;
		
		Stack<Integer> stack = new Stack<>();
		
		while(true) {						//달팽이 배열처럼 돌기
			if(map[nowi][nowj]!=0) {		//구슬이 있다면
				stack.push(map[nowi][nowj]);	//스택에 넣기
			}
			
			number[nowi][nowj] = num--;		//숫자 거꾸로 채우기
			if(num==0) {					
				break;
			}
			
			int nexti = nowi+deli[d];
			int nextj = nowj+delj[d];
			
			if(nexti<0 || nextj<0 || nexti>=N || nextj>=N || number[nexti][nextj] !=0) {		//배열범위 벗어나거나 다음칸에 숫자가 채워져 있다면
				d++;				//방향틀기
				if(d>3) {
					d=0;
				}
			}
			
			nowi=nowi+deli[d];
			nowj=nowj+delj[d];
		}
		
		List<Integer> list = new ArrayList<>();		//구슬정보 담을 리스트
		list.add(99);		//0번 인덱스에 상어
		while(!stack.isEmpty()) {					//스택에 넣었던 구슬정보들 
			list.add(stack.pop());					//리스트에 추가(역순으로 넣으니까 1번자리부터 리스트에 추가됨)
		}
		
		
		
		
		Stack<Integer> stack2 = new Stack<>();		//마법쓰면 파괴되는 구슬 담을 리스트
		
		int sum1=0;	//폭발한 1번구슬개수
		int sum2=0;	//폭발한 2번구슬개수
		int sum3=0;	//폭발한 3번구슬개수
		
		//블리자드 쓴다
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int magicD = Integer.parseInt(st.nextToken());
			int magicS = Integer.parseInt(st.nextToken());
			
			int MagicI = N/2;
			int MagicJ = N/2;
			for(int j=0;j<magicS;j++) {
				int nextI = MagicI+di[magicD];
				int nextJ = MagicJ+dj[magicD];
				
				stack2.push(number[nextI][nextJ]);		//마법범위에 있는 구슬들 스택에 넣기
				
				MagicI=nextI;
				MagicJ=nextJ;
			}
			

			
			while(!stack2.isEmpty()) {
				int tmp = stack2.pop();			//tmp는 마법으로 파괴된 구슬이 있던 위치(리스트의 인덱스)
				if(list.size()-1>=tmp) {
					list.remove(tmp);			//리스트에서 제거(자동으로 땡겨짐)
				}
			}
			

			//이제 폭발한다
			//폭발할 구슬 탐색
			
			
			while(true) {
				boolean flag= false;		//폭발하는 구슬 있는지 확인
				if(list.size()>4) {
					
					int cnt=1;					//1개부터시작
					int L=list.size();			
					int temp = list.get(L-1);	//맨뒤에 있는 애부터 거꾸로 보기
					for(int j=L-2;j>0;j--) {	
						if(list.get(j)==temp) {		//하나씩 거꾸로 가면서 이전거랑 같은지 확인
							cnt++;				//같으면 개수증가
						}else {					//다르면 개수 1로 초기화 하고 그 전까지 개수가 4개이상이면 폭발시키기
							if(cnt>=4) {		
								flag = true;	//폭발한애있으면 다음에 또 탐색
								if(temp==1) {
									sum1 +=cnt;
								}else if(temp==2) {
									sum2 +=cnt;
								}else if(temp==3) {
									sum3 +=cnt;
								}
								for(int k=0;k<cnt;k++) {
									list.remove(j+1);		//연속된 수만큼 리스트에서 삭제
								}
							}
							cnt=1;				//그전까지 연속한게 4개 이상이 아니면 개수 초기화
							temp=list.get(j);	//임시변수 바꿔주기
						}
						if(j==1 && cnt>=4) {
							flag = true;
							if(temp==1) {
								sum1 +=cnt;
							}else if(temp==2) {
								sum2 +=cnt;
							}else if(temp==3) {
								sum3 +=cnt;
							}
							for(int k=0;k<cnt;k++) {
								list.remove(j);
							}
						}
					}
				}
				if(!flag) {		//더 이상 연속된 애 없으면 와일문 나가기
					break;	
				}
				
			}
			
			
			
			

			
			//이제 구슬 변화한다.(카피리스트 필요)
			List<Integer> copyList = new ArrayList<>();
			for(int j=0;j<list.size();j++) {
				copyList.add(list.get(j));
			}
			
			list.clear();
			list.add(99);		//상어
			
			if(copyList.size()>2) {
				int cnt=1;		
				int temp = copyList.get(1);				//1번부터 
				for(int j=2;j<copyList.size();j++) {	//리스트 차례대로 탐색하면서
					if(copyList.get(j)==temp) {
						cnt++;							//연속하는지 보고 개수 늘려줌
						if(j==copyList.size()-1) {
							list.add(cnt);
							if(list.size()>=N*N) {			//배열범위 꽉차면 브레이크
								break;
							}
							list.add(temp);					//연속이 끊기면 이전까지  연속된 구슬 번호 리스트에 추가
							if(list.size()>=N*N) {			//배열범위 꽉차면 브레이크
								break;
							}
						}
					}else {								//연속이 끊기면 이전까지 연속된 구슬 개수 리스트에 추가하고
						list.add(cnt);
						if(list.size()>=N*N) {			//배열범위 꽉차면 브레이크
							break;
						}
						list.add(temp);					//연속이 끊기면 이전까지  연속된 구슬 번호 리스트에 추가
						if(list.size()>=N*N) {			//배열범위 꽉차면 브레이크
							break;
						}
						cnt=1;							//연속개수 초기화
						temp=copyList.get(j);			//임시변수 바꿔주기
					}
					
				}
				
			}else if(copyList.size()==2){
				list.add(1);
				int temp = copyList.get(1);
				list.add(temp);
			}else {
				break;
			}
			
			
			
			
			
			
			
		}
		
		
		System.out.println(sum1+2*sum2+3*sum3);
	}

}
