import sys
from collections import deque
input=sys.stdin.readline

n=int(input())
rule=list(map(int,input().split()))
num=1
result=deque()
while rule:
    t=rule.pop()
    if t==1:
        result.appendleft(num)
    elif t==2:
        result.insert(1,num)
    elif t==3:
        result.append(num)
    num+=1
print(*result)
