import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph=[[] for _ in range(n+1)]
visited=[False]*(n+1)

for _ in range(n-1):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

que = deque()
que.append([1,0])
answer =[0 for _ in range(n+1)]

while que:
    node, parent = que.popleft()
    #print(node, parent)
    answer[node]=parent
    visited[node]=True
    for child in graph[node]:
        if not(visited[child]):
            que.append([child, node])
    

for i in answer[2:]:
    print(i)

"""
10
1 3
5 4
3 2
2 7
5 7
9 10
5 10
6 8
1 6
ans:
3
1
5
7
1
2
6
10
5
"""


"""
3
2 3
1 2
ans:
1
2
"""

"""
3
2 3
2 1
ans:
1
2
"""