from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
arr = reversed(list(map(int, input().split())))
res = deque(range(1,n+1))
que = deque()

for i in arr:
    p = res.popleft()
    if i == 1:
        que.appendleft(p)
    elif i==2:
        que.insert(1,p)
    else:
        que.append(p)



print(*que)