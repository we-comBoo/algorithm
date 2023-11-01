import heapq
import sys
input=sys.stdin.readline

n,m=map(int,input().split())
gift=[]

temp=list(map(int,input().split()))
for i in temp:
    heapq.heappush(gift,(-i,i))
child=list(map(int,input().split()))

for i in child:
    a,t=heapq.heappop(gift)
    if t>=i:
        t-=i
        heapq.heappush(gift,(-t,t))
    else:
        print(0)
        exit()
print(1)
