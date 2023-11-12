from heapq import heappop, heappush
# 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로

import sys
input = sys.stdin.readline
# 정점의 개수 N과 간선의 개수 E
n,e = map(int, input().split())
INF = int(1e9)

graph = [[] for _ in range(n+1)]


for _ in range(e):
    # 정점1, 정점2, 비용
    a,b,c = map(int, input().split())
    graph[a].append([c, b])
    graph[b].append([c, a])

v1, v2 = map(int, input().split())
def dijkstra(start, end):
    dist = [INF]*(n+1)
    heap = []
    dist[start] = 0
    heappush(heap, [dist[start], start])
    while heap:
        now_cost, now_node = heappop(heap)
        for next_cost, next_node in graph[now_node]:
            distance = next_cost+now_cost
            if dist[next_node]>distance:
                dist[next_node] = distance
                heappush(heap,[dist[next_node], next_node])
    return dist[end]


ans1 = dijkstra(1, v1)+dijkstra(v1, v2)+dijkstra(v2, n)
ans2 = dijkstra(1, v2)+dijkstra(v2, v1)+dijkstra(v1, n)
if ans1>=INF and ans2>=INF:
    print(-1)
else:
    print(min(ans1, ans2))
    
    