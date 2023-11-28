import sys
input = sys.stdin.readline
from heapq import heappop, heappush

heap = []

n,m = map(int, input().split())
indegree = [0 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    indegree[b]+=1

for i in range(1, n+1):
    if indegree[i]==0:
        heappush(heap,i)
answer = []
while heap:
    curr = heappop(heap)
    answer.append(curr)
    for next_ in graph[curr]:
        indegree[next_]-=1
        if indegree[next_]==0:
            heappush(heap, next_)

print(*answer)
