import heapq
import sys
input=sys.stdin.readline

n=int(input())
num=[]
for _ in range(n):
    x=int(input())
    if x==0:
        if not num:
            print(0)
        else:
            print(heapq.heappop(num))
    else:
        heapq.heappush(num,x)
