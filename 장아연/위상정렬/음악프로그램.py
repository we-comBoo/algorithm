import sys
input = sys.stdin.readline
from collections import deque


# 가수 수, 보조 피디 수
n,m =map(int, input().split())
indegree = [0 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]
que = deque()
for _ in range(m):
    arr = list(map(int, input().split()[1:]))
    for idx in range(len(arr)-1):
        a, b = arr[idx], arr[idx+1]
        graph[a].append(b)
        indegree[b]+=1
for i in range(1, n+1):
    if indegree[i]==0:
        que.append(i)
answer= []
while que:
    now = que.popleft()
    answer.append(now)
    for next_ in graph[now]:
        indegree[next_]-=1
        if (indegree[next_]==0):
            que.append(next_)


if len(answer)==n:
    for i in answer:
        print(i)
else:
    print(0)
        