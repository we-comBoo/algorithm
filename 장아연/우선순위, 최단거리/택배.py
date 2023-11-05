# 집하장 갯수, 집하장 간 경로 갯수
n,m = map(int, input().split())
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]
dist = [["-"]*(n+1) for _ in range(n+1)]

# 자기 자신에서 자기 자신으로는 거리 0
for i in range(1,n+1):
    graph[i][i]=0

for _ in range(m):
    start, end, cost = map(int, input().split())
    # 양방향 그래프
    graph[start][end]=graph[end][start]=cost
    # 각 경로의 첫번째 집하장
    dist[start][end]=end
    dist[end][start]=start
    
for k in range(1, n+1):
    for s in range(1, n+1):
        for e in range(1,n+1):
            cost = graph[s][k]+graph[k][e]
            if graph[s][e]>cost:
                graph[s][e] = cost
                # k로 가기 위한 첫번째 집하장
                dist[s][e]=dist[s][k]
                


for i in dist[1:]:
    print(*i[1:])
