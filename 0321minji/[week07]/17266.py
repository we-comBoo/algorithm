import sys
input=sys.stdin.readline

n=int(input())
m=int(input())
x=list(map(int,input().split()))

dist=0

for i in range(1,m):
    dist=max(dist,x[i]-x[i-1])
    #가장 큰 거리

print(max((dist+1)//2, x[0]-0 , n-x[-1]))
