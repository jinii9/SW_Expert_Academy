/*
 * 정말 바보같이 입력할 때 nextLine을 받음 -> 이후 s문자열에 받아서 -> Integer로 바꿔준다음 arr에 넣어주려고 했음
 * => 이런 방식 쓰일 때를 제대로 구분할 것!
 */
import java.util.*;

public class Flatten_1208 {
	
	public static int dump = 0;
	//public static String height = "";
	public static int [] arr = new int[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; t++) {
			dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for(int i=0; i<dump; i++) {
				//arr[i]++;
				//arr[99-i]--;
				//위에는 당연히 안될 수밖에.. => dump가 834번인데, arr의 크기는 100이기 때문에 성립X
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
				//System.out.println(arr[i] + " " + arr[99-i]);
			}
			
			System.out.println("#" + (t+1) + " " + (arr[99]-arr[0]));
		}	
	}

}
