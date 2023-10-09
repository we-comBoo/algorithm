from collections import deque 

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
n = int(input())
graph= [list(map(int, input()))for _ in range(n)]
ans = []


def bfs(graph, a, b):
    graph[a][b]=0
    cnt = 1
    queue = deque()
    queue.append((a,b))
    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            #print(nx, ny)
            if nx < 0 or nx >= n or ny <0 or ny >= n:
                #print("탈출")
                continue

            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx,ny))
                cnt += 1
    #print("단지 끝",cnt)
    return cnt

for i in range(n):
    for j in range(n):
        if graph[i][j]==1:
            ans.append(bfs(graph, i, j))
#print(ans)
print(len(ans))
for i in sorted(ans):
    print(i)