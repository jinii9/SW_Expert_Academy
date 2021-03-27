import java.util.Scanner;
 
public class nQueen_2806 {
    public static int N, T;
    public static int count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
      
        for(int testnum=1; testnum<=T; testnum++) {
        	N = sc.nextInt();
        	// �� �࿡�� �ϳ��� ������ ���� ������ �� �ִ�.
            // 1 ������ N������ ���鼭 �� 1�� N���� ���� �������� ������ ��츦 Ȯ���Ѵ�.
        	
	        for(int i = 1; i <= N; i++) {
	            int[] col = new int[N+1]; // N * N ����̱⿡ ���� �ε����� N ���� ���� �� �ְ� �Ѵ�.
	            
	            // 1�� i���� ���� ���Ҵ�.
	            col[1] = i;
	            // 1�� i���� ���� ������ ��� ������ Ƚ���� dfs�� ���Ѵ�.
	            dfs(col, 1);
	        }
	        
	        System.out.println("#" + testnum + " " + count);
	        count=0;
        }
    }
    // row ������� ���� ���Ҵ�.    
    // row+1�࿡ ���� ������ �ִ��� Ȯ���Ѵ�.
    // ���� row ���� N �� ���ٸ� N ����� ���� ���Ҵٴ� ���̹Ƿ� count�� 1 ���������ش�.
    public static void dfs(int[] col, int row) {
        if(row == N) {
            count++;
        }else {
            // 1�� ���� N ������ �ݺ��ϸ鼭 (row+1, i)�� ���� ���� �� �ִ°�찡 �ִ��� Ȯ���Ѵ�.
            // ������ �������� dfs�� ȣ���Ѵ�.
            for(int i = 1; i <= N; i++) {
                col[row+1] = i;
                if(isPossible(col, row+1)) {
                    dfs(col, row+1);
                }
            }
        }
    }
    
    public static boolean isPossible(int[] col, int row) {
        // 1����� row ����� ���� �� Ȥ�� �밢���� ��ġ�ϴ� ���� �ִ��� Ȯ���Ѵ�.
        
        for(int i=1; i < row; i++) {
            // i ��� row ���� �� ���� ������ ���� ������ ����. 
            if(col[i] == col[row]) 
            	return false;
            
            // i ��� row ���� ������ �밢���� ��ġ�ϴ� ���밪�̸� �ȵȴ�.
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) 
            	return false;
        }
        return true;
    }
}