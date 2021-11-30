package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2564_경비원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int x = Integer.parseInt(st.nextToken());
	       int y = Integer.parseInt(st.nextToken());
	       int N = Integer.parseInt(br.readLine());
	       Posi[] arr = new Posi[N];
	       
	       for(int i=0;i<N;i++) {
	    	   st = new StringTokenizer(br.readLine());
	    	   arr[i] = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    	   
	       }
	       st = new StringTokenizer(br.readLine());
	       Posi dong = new Posi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	       //입력 끝
	       
	       for(int i=0;i<N;i++) {
	    	   if(arr[i].y==1) {
	    		   arr[i].y =y;
	    	   }else if(arr[i].y==2) {
	    		   arr[i].y=0;
	    	   }else if(arr[i].y==3) {
	    		   arr[i].y=y-arr[i].x;
	    		   arr[i].x=0;
	    	   }else if(arr[i].y==4) {
	    		   arr[i].y=y-arr[i].x;
	    		   arr[i].x=x;
	    	   }
	       }
	       if(dong.y==1) {
    		   dong.y =y;
    	   }else if(dong.y==2) {
    		   dong.y=0;
    	   }else if(dong.y==3) {
    		   dong.y=y-dong.x;
    		   dong.x=0;
    	   }else if(dong.y==4) {
    		   dong.y=y-dong.x;
    		   dong.x=x;
    	   }
	       int i=0;
	       int sum=0;
	       while(i<N) {
	    	   int min = Integer.MAX_VALUE;
	    	   if(Math.abs(arr[i].x-dong.x)==x) {
	    		   min = Math.min(x+arr[i].y+dong.y, x+(y-arr[i].y)+(y-dong.y));
	    	   }else if(Math.abs(arr[i].y-dong.y)==y){
	    		   min = Math.min(y+arr[i].x+dong.x, y+(x-arr[i].x)+(x-dong.x));
	    	   }else {
	    		   min = Math.abs(dong.x-arr[i].x)+Math.abs(dong.y-arr[i].y);
	    	   }
	    	   sum +=min;
	    	   i++;
	       }
	       System.out.println(sum);
	       
	}
	static class Posi{
		int y;
		int x;
		public Posi(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		}
		
	}

