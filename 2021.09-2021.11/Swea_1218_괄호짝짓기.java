package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_1218_괄호짝짓기 {

	static String open = "({[<";				//여는괄호
	static String close = ")}]>";				//닫는 괄호
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int num = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Stack<String> stack = new Stack<>();			//여는괄호를 만나면 스택에 넣어주기 위해 스택생성
			
			boolean flag = true;							//여는괄호와 닫는괄호가 짝이 다 맞는지 판별하기위한 불린변수
			
			for(int i=0;i<num;i++) {
				String one = str.substring(i, i+1);			//하나씩 꺼내서
				
				if(open.contains(one)) {					//여는괄호면
					stack.push(one);						//스택에 넣기
				}else if(!stack.isEmpty()) {				//닫는괄호고 스택이 비어있지 않다면
					String get = stack.pop();				//가장 최근에 스택으로 들어간 여는 괄호 꺼내기
					if(open.indexOf(get)!=close.indexOf(one)) {			//짝이 안맞는 경우
						flag = false;						//짝안맞음
						break;							//더 볼 필요도 없다
					}
				}else {									//닫는괄호가 스택이 비어있다면
					flag =false;						//짝 안맞음
					break;								//더 볼필요 없음
				}
				
			}
			if(!stack.isEmpty()) {			//개수가 안맞는 경우
				flag = false;				//안맞음
			}
			
			if(flag) {
				System.out.println("#"+tc+" 1");
			}else {
				System.out.println("#"+tc+" 0");
			}
			
			
		}

	}

}
