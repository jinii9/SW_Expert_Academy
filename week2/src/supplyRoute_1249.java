/*
 * bfs-�ִܰ��Ž��
 * dfs/bfs ���� Ǯ ������, ���� ������� ��ΰ� �������� �ϳ��ϳ� üũ(�׸�)�غ��� �ڵ��� ��
 * bfs�� ����Ǿ, ť���� ���ְ� ����� �� ��� �ִ´ٴ� �⺻���� ����� ���� 
 * �湮���� ��쿡��, ���Ͽ� result�迭�� ���� min������ �־��� ��!
 * */
import java.util.*;

class Node {
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}

public class supplyRoute_1249 {
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] result;
	//public static int minimum = -1;
	
	public static int bfs(int x, int y, int mapsize) {
		Queue<Node> q = new LinkedList<>();
		//ť�� �ϳ� �ֱ�
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
            y = node.getY();
			int nx=0, ny=0;
			
			for(int i=0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=mapsize || ny>=mapsize) {
					continue;
				}
				
				//////////
				if(!visited[nx][ny]) {
					q.offer(new Node(nx,ny));
					visited[nx][ny] = true;
					result[nx][ny] = result[x][y] + map[nx][ny];
				}
				else {
					if(result[nx][ny] > result[x][y]+map[nx][ny]) {
						result[nx][ny] = result[x][y] + map[nx][ny];
						q.offer(new Node(nx,ny));
					}
				}
				
			}
		}
		//�����
		for(int i=0; i<mapsize; i++) {
			for(int j=0; j<mapsize; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println("");
		}
		return result[mapsize-1][mapsize-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int t=0; t<testcase; t++) {
			int mapsize = sc.nextInt();
			visited = new boolean[mapsize][mapsize];
			map = new int[mapsize][mapsize];
			result = new int[mapsize][mapsize];
			
			for(int i=0; i<mapsize; i++) {
				String str = sc.next();
				String arr[] = str.split("");
				for(int j=0; j<mapsize; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}
			/*
			//�� �����
			for(int i=0; i<mapsize; i++) {
				for(int j=0; j<mapsize; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			*/
			/*
			//�����
			for(int i=0; i<mapsize; i++) {
				for(int j=0; j<mapsize; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}
			*/
			//���Ž��
			System.out.println("#" + (t+1) + " " + bfs(0,0,mapsize));
		}
	}

}

/*
 * �߸� ������ Ǯ��
	public static int bfs(int x, int y, int mapsize) {
		Queue<Node> q = new LinkedList<>();
		//ť�� �ϳ� �ֱ�
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			//ť���� �ϳ� ����
			//q.poll();
			Node node = q.poll();
			x = node.getX();
            y = node.getY();
			//ť�� ����� ���� �湮���� ���� �� ���� 
			//�����¿� �߿��� ���� ���� �� ����
			int nx=0, ny=0;
			int min=9876;
			//int ax=0, ay=0;
			
			for(int i=0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=mapsize || ny>=mapsize) {
					//map[nx][ny] = minimum;
					continue;
				}
				//if(min >= map[nx][ny]) {
					//min = map[nx][ny];
					//x = nx;
					//y = ny;
					//ax = nx;
					//ay = ny;
				//}
			
				//x = ax;
				//y = ay;
				//�����
				System.out.println(x + "," + y);
				//�湮���� �ʾҴٸ�, ť�� ����
				if(!visited[x][y]) {
					q.offer(new Node(x,y));
					visited[x][y] = true;
					//�� �� ����
					//map[x][y] = map[x][y] + min;
					//�����
					//System.out.println(map[x][y]);
				}
			}
		}
		//����� ����
		//return map[mapsize-1][mapsize-1];
		return result;
	}
 */
