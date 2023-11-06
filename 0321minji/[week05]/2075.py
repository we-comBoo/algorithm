import heapq
import sys
input=sys.stdin.readline

n=int(input())
num=[]

for i in range(n):
    num.append(list(map(int,input().split())))

index=[(n-1)]*n
for i in range(n-1):
    t=max(num[n-1])    
    temp=num[n-1].index(t)
    index[temp]-=1
    num[n-1][temp]=num[index[temp]][temp]
    #print(num[n-1])
print(max(num[n-1]))
