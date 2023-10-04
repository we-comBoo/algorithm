import sys
from collections import deque
input = sys.stdin.readline

dr=[-1,1,0,0]
dc=[0,0,-1,1]

T = int(input())

for _ in range(T):
    # 가로 길이, 세로 길이, 배추 위치 갯수
    m,n,k = map(int, input().split())
    graph = [[0]*m for _ in range(n)]
    visited = [[False]*m for _ in range(n)]
    
    for _ in range(k):
        x,y = map(int, input().split())
        graph[y][x]=1
        
        
    def bfs(x,y):
        que = deque()
        que.append([x,y])
        visited[x][y]=True
        
        while que:
            r,c=que.popleft()
            for idx in range(4):
                nr, nc = r + dr[idx], c+ dc[idx]
                if not(0<=nr<n and 0<=nc<m):
                    continue
                if not(visited[nr][nc]) and graph[nr][nc]==1:
                    que.append([nr, nc])
                    visited[nr][nc]=True
    
    
    count=0
    for r in range(len(graph)):
        for c in range(len(graph[r])):
            if graph[r][c]==1 and not(visited[r][c]):
                count+=1
                bfs(r,c)
                
    print(count)
            