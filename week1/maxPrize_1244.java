/*
 * dfs�� Ǯ�� : �׷����� �ƴ϶� �̷� ���� Ž�� �������� dfs�� ��� ���̴��� ����� �� ��
 * testcase������ ��û ���� �ɸ� : 
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
		if(cnt == move) {//��ü ��ȸ �� ���� ��
			str = "";
			//arr�迭�� str�� �ٲٱ�
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
		//���� ����� �������� �ٲ� ������, ��� ��� ����
		for(int i=k; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]<=arr[j] || arr.length==2) {
					check=1;
					//swap
					prize = arr[i];
					arr[i] = arr[j];
					arr[j] = prize;
					dfs(i, cnt+1);
					//���� �ڸ��� ��������
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
						//���� �ڸ��� ��������
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
			//�ϳ��� ��
			//arr[i] = sc.nextInt();
			//���� ���ڷ� �ޱ�
			String num = sc.next();
			move = sc.nextInt();

			//num ���ڸ��� �ɰ���
			//String[] arr = new String[num.length()];
			
			//num ���ڸ��� �ڸ���
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
		 * �����
		for(int i=0; i<testcase; i++) {
			System.out.println(arr[i] + " " + move);
		}
		*/
		}
	}

}
