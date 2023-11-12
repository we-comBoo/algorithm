#1->v1->v2->n or 1->v2->v1->n 둘 중 최소

import sys, heapq
input=sys.stdin.readline

def dij(start):
    dist=[10**9]*(n+1)
    dist[start]=0
    pq=[]
    heapq.heappush(pq,(0,start))

    while pq:
        w, end= heapq.heappop(pq)
        for nxt, nxt_w in graph[end]:
            wei=nxt_w+w
            if dist[nxt]>wei:
                dist[nxt]=wei
                heapq.heappush(pq,(wei,nxt))

    return dist
    

n,e=map(int,input().split())
graph=[[]for _ in range(n+1)]

for _ in range(e):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

v1,v2=map(int,input().split())

dis1=dij(v1)
dis2=dij(v2)

result=min(dis1[1]+dis1[v2]+dis2[n],dis2[1]+dis2[v1]+dis1[n])
print(result if result<10**9 else -1)
