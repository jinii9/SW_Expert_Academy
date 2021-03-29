/*
 * 마름모꼴 구하는 문제
 * 중심축을 기준으로 생각하기
 * 최대한 한묶음의 for문으로 최소한 계산할 수 있는지 생각하기
 * => 그러기 위해선 i나 j가 변하는 수여야 함. ex) j=(n/2-i)
 */
import java.util.*;

public class crops_2805 {
	
	public static int [][] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int t=0; t<testcase; t++) {
			int n = sc.nextInt();
			arr = new int[n][n];
			
			//입력받기
			for(int l=0; l<n; l++) {
				String input = sc.next();
				String[] s = input.split("");
				
				for(int p=0; p<n; p++) {
					arr[l][p] = Integer.parseInt(s[p]);
				}
			}
			
			int sum = 0;
			//상단 삼각형
			for(int i=0; i<n/2; i++) {
				for(int j=(n/2-i); j<=(n/2+i); j++) {
					sum += arr[i][j];
				}
			}
			
			//하단 삼각형
			for(int i=n/2; i>=0; i--) {
				for(int j=(n/2-i); j<=(n/2+i); j++) {
					sum += arr[n-i-1][j];
				}
			}
	
			System.out.println("#" + (t+1) + " " + sum);
			/*
			//상단 삼각형
			int cnt = 0;
			int sum = 0;
			for(int i=n/2; i>=0; i++) {
				for(int j=n/2; j>=cnt; j--) {
					sum += arr[i][j];
				}
				cnt++;
			}
			*
			
			/*디버깅
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			*/
		}
	}

}
