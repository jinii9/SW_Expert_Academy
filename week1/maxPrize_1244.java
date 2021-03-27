/*
 * dfs로 풀이 : 그래프가 아니라 이런 완전 탐색 문제에서 dfs가 어떻게 쓰이는지 제대로 알 것
 * testcase때문에 엄청 오래 걸림 : 
 * 1
 * 4321 1
 * -------
 * 1
 * 94 1	 
 * */
import java.util.*;
public class maxPrize_1244 {
	
	public static int[] arr;
	public static int move, result, prize;
	public static String str = "";
	public static int compare;
	
	public static void dfs(int k, int cnt) {
		if(cnt == move) {//교체 기회 다 썼을 때
			str = "";
			//arr배열을 str로 바꾸기
			for(int i=0; i<arr.length; i++) {
				str = str + Integer.toString(arr[i]);
			}
			compare = Integer.parseInt(str);
			//System.out.println(compare);
			//System.out.println(compare);
			//System.out.println(result);
			result = Math.max(result, compare);
			return;
		}
		int check=0;
		//뒤의 값들과 차례차례 바꿔 나가며, 모든 경우 조사
		for(int i=k; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]<=arr[j] || arr.length==2) {
					check=1;
					//swap
					prize = arr[i];
					arr[i] = arr[j];
					arr[j] = prize;
					dfs(i, cnt+1);
					//원래 자리로 돌려놓기
					prize = arr[i];
					arr[i] = arr[j];
					arr[j] = prize;
				}
				
			}
		}
		if(check==0) {
			//for(int i=arr.length-1; i>=k; i--) {
				//for(int j=i-1; j>=0; j--) {
						
						prize = arr[arr.length-1];
						arr[arr.length-1] = arr[arr.length-2];
						arr[arr.length-2] = prize;
						dfs(arr.length-1, cnt+1);
						//원래 자리로 돌려놓기
						//prize = arr[i];
						//arr[i] = arr[j];
						//arr[j] = prize;
				
				//}
			//}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		//arr = new int[testcase];
		
		for(int i=0; i<testcase; i++) {
			//하나씩 비교
			//arr[i] = sc.nextInt();
			//숫자 문자로 받기
			String num = sc.next();
			move = sc.nextInt();

			//num 한자리씩 쪼개기
			//String[] arr = new String[num.length()];
			
			//num 한자리씩 자르기
			String[] num2 = num.split("");
			arr = new int[num.length()];
			for(int j=0; j<num.length(); j++) {
				//System.out.println(num2[j]);
				arr[j] = Integer.parseInt(num2[j]);
								
			}
		
			result = 0;
			dfs(0,0);
			
			System.out.println("#" + (i+1) + " " + result);
		/* 
		 * 디버깅
		for(int i=0; i<testcase; i++) {
			System.out.println(arr[i] + " " + move);
		}
		*/
		}
	}

}
