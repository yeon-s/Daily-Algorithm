package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] =  Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		int[][] D = new int[N+1][K+1];				//N번째 물건까지 고려했을때, K무게까지 고려했을때 최대가치를 저장하기 위한 이차원 배열
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(j>=weight[i]) {					//현재 추가된 물건을 담을 수 있다면
					D[i][j] = Math.max(D[i-1][j], D[i-1][j-weight[i]]+value[i]);//이전물건까지 고려된 최대무게에서 현재 추가된 물건의 무게를 빼고 현재 추가된 물건의 가치를 더한 값과 이전물건까지의 최대가치중 높은 것  
				}else {						//현재 추가된 물건 담을 수 없다면
					D[i][j] = D[i-1][j];	//이전물건까지의 최대가치 그대로
				}
			}
		}
		
		System.out.println(D[N][K]);
	}

}
