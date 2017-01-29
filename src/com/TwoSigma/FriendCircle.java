package com.TwoSigma;

public class FriendCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] matrix = new char[4][4];
		
				matrix[0][0]='Y';
				matrix[0][1]='Y';
				matrix[0][2]='N';
				matrix[0][3]='N';
				matrix[1][0]='Y';
				matrix[1][1]='Y';
				matrix[1][2]='Y';
				matrix[1][3]='N';
				matrix[2][0]='N';
				matrix[2][1]='Y';
				matrix[2][2]='Y';
				matrix[2][3]='N';
				matrix[3][0]='N';
				matrix[3][1]='N';
				matrix[3][2]='N';
				matrix[3][3]='Y';
				
				String[] friends={"YYNN", "YYYN", "NYYN", "NNNY"};
				String[] friends1={"YNNNN", "NYNNN", "NNYNN", "NNNYN", "NNNNY"};
				
				int circles=0;
				boolean[] visited = new boolean[friends.length];
				for(int i=0;i<visited.length;i++)
					visited[i]=false;
				for(int i=0; i<friends.length;i++){
					if(!visited[i]){
						circles++;
						visited[i]=true;
						friendCircle(friends, visited, i);
					}
				}
				
				System.out.println(circles);
	}

	public static void friendCircle(String[] friends, boolean[] visited, int id){
		
		for(int i=0;i<friends.length;i++){
			if(!visited[i] && i!=id && friends[id].charAt(i)=='Y'){
				visited[i]=true;
				friendCircle(friends, visited, i);
			}
		}
		
	}
	
	
	public static void dfs(char [][] matrix, boolean[] visited, int id){
		
		for(int i=0;i<matrix.length;i++){
			if(!visited[i] && i!=id && matrix[id][i]=='Y'){
				visited[i]=true;
				dfs(matrix, visited, i);
			}
		}
		
	}
}
