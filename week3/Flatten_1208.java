/*
 * ���� �ٺ����� �Է��� �� nextLine�� ���� -> ���� s���ڿ��� �޾Ƽ� -> Integer�� �ٲ��ش��� arr�� �־��ַ��� ����
 * => �̷� ��� ���� ���� ����� ������ ��!
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
				//������ �翬�� �ȵ� ���ۿ�.. => dump�� 834���ε�, arr�� ũ��� 100�̱� ������ ����X
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
				//System.out.println(arr[i] + " " + arr[99-i]);
			}
			
			System.out.println("#" + (t+1) + " " + (arr[99]-arr[0]));
		}	
	}

}
