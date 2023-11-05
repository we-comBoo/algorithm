from heapq import heappop, heappush
import sys
input = sys.stdin.readline


def dijkstra(start):
    heap = []
    distance[start]=0
    heappush(heap,(distance[start], start))
    while heap:
        dist, now =heappop(heap)
        for next_, cost in graph[now]:
            dist_ = dist+cost
            if distance[next_]>dist_:
                distance[next_]=dist_
                heappush(heap, (distance[next_], next_))

def getResult():
    count = 0
    dist = 0
    for i in distance:
        if i != INF:
            dist=max(dist, i)
            count+=1
    print(count, dist)
T = int(input())

for _ in range(T):
    # 컴퓨터 갯수, 의존성 갯수, 해킹당한 컴퓨터 번호
    n,d,c =map(int, input().split())
    INF = int(1e9)
    # 노드 연결 정보
    graph=[[] for _ in range(n+1)]
    # 거리 정보
    distance = [INF]*(n+1)
    
    for _ in range(d):
        # 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
        a, b ,s = map(int, input().split())
        graph[b].append((a,s))
        # graph[a].append((b,s)) 아님...
    dijkstra(c)

    getResult()