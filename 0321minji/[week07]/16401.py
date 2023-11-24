#16401

import sys
input=sys.stdin.readline

m,n=map(int,input().split())

sn=list(map(int,input().split()))

low=1;high=max(sn)

result=0

while(low<=high):
    mid=(low+high)//2
    cnt=0
    for i in range(n):
        cnt+=sn[i]//mid

    if cnt>=m:
        result=mid
        low=mid+1
    else:
        high=mid-1

print(result)
