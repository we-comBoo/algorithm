## https://www.acmicpc.net/problem/19538

import sys
input = sys.stdin.readline
from collections import deque 

n = int(input())
graph = [0]
visited = [0] * (n+1)
ans = [-1] * (n+1)
for i in range(n):
    *a, b = map(int, input().split())
    graph.append(a)
m = int(input())
start=list(map(int, input().split()))

que = deque()
cnt = [0]*(n+1)
for i in start:
    visited[i]=1
    ans[i]=0
    que.append(i)
    


def bfs():
    while que:
        #print(ans)
        current = que.popleft()
        for next in graph[current]:
            if not visited[next]:
                cnt[next]+=1
                #print(next, "방문안함")
                if cnt[next] >= (len(graph[next])+1)//2:
                    #print("큐 추가", ans[current])
                    visited[next]=1
                    ans[next] = ans[current]+1
                    que.append(next)
            #print("친구 : ",next)



bfs()
print(*ans[1:])
