#####예제랑 질문게시판에 있는 tc들은 다 통과하는데 pypy3로 제출해도 시간초과..............ㅠㅠ

import sys, heapq
input=sys.stdin.readline
from collections import deque

n,m,t=map(int,input().split())
build=list(map(int,input().split()))
sc=[[] for _ in range(n+1)]
check=[0]*(n+1)
for i in range(1,n+1):
    temp=list(map(int,input().split()))
    sc[i]=temp[1:]

need=[[] for _ in range(n+1)]
for _ in range(n-m):
    temp=list(map(int,input().split()))
    need[temp[0]]=temp[2:]

dq=deque([])

for i in build:
    dq.append([i,0])

result=[]
while dq:
    temp=dq.popleft()
    if temp[1]>t:
        break
    result.append(temp[0])
    for i in sc[temp[0]]:
        if check[i]:
            continue
        check[i]=1
        for j in range(n+1):
            if not need[j]:
                continue
            if i in need[j]:
                need[j].remove(i)
            if not need[j]:
                dq.append([j,temp[1]+1])
result.sort()
print(len(result))
print(*result)
