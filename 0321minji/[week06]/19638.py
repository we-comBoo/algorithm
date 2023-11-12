import heapq
import sys
input=sys.stdin.readline

n,h,t=map(int,input().split())
other=[]

for _ in range(n):
    k=int(input())
    heapq.heappush(other,-k)
    
for i in range(t):
    if -other[0]==1 or -other[0]<h:
        i-=1
        break
    else:
        heapq.heapreplace(other,-(-other[0]//2))
        
if -other[0]>=h:
    print('NO')
    print(-other[0])
else:
    print('YES')
    print(i+1)
