/*
 * bfs-최단경로탐색
 * dfs/bfs 문제 풀 때에는, 먼저 어떤식으로 경로가 나오는지 하나하나 체크(그림)해보고 코딩할 것
 * bfs는 응용되어도, 큐에서 빼주고 연결된 값 모두 넣는다는 기본적인 사실은 동일 
 * 방문했을 경우에는, 비교하여 result배열에 가장 min값으로 넣어줄 것!
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
		//큐에 하나 넣기
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
		//디버깅
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
			//맵 만들기
			for(int i=0; i<mapsize; i++) {
				for(int j=0; j<mapsize; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			*/
			/*
			//디버깅
			for(int i=0; i<mapsize; i++) {
				for(int j=0; j<mapsize; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println("");
			}
			*/
			//경로탐색
			System.out.println("#" + (t+1) + " " + bfs(0,0,mapsize));
		}
	}

}

/*
 * 잘못 생각한 풀이
	public static int bfs(int x, int y, int mapsize) {
		Queue<Node> q = new LinkedList<>();
		//큐에 하나 넣기
		q.offer(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			//큐에서 하나 빼기
			//q.poll();
			Node node = q.poll();
			x = node.getX();
            y = node.getY();
			//큐와 연결된 아직 방문되지 않은 것 삽입 
			//상하좌우 중에서 가장 작은 갑 삽입
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
				//디버깅
				System.out.println(x + "," + y);
				//방문하지 않았다면, 큐에 삽입
				if(!visited[x][y]) {
					q.offer(new Node(x,y));
					visited[x][y] = true;
					//맵 값 갱신
					//map[x][y] = map[x][y] + min;
					//디버깅
					//System.out.println(map[x][y]);
				}
			}
		}
		//결과값 도출
		//return map[mapsize-1][mapsize-1];
		return result;
	}
 */
