#kruskal

import sys
input=sys.stdin.readline

def find(x):
    if x!=parent[x]:
        parent[x]=find(parent[x])
    return parent[x]

def union(x,y):
    a=find(x)
    b=find(y)

    if a<b:
        parent[b]=a
    else:
        parent[a]=b
        

def kruskal(v,total,pq):
    cnt=0

    for w,a,b in pq:
        if find(a)!=find(b):
            union(a,b)
            total-=w
    for i in range(1,n):
        if i==parent[i]:
            cnt+=1
            
    if cnt>1:
        return -1
    else:
        return total

n,m=map(int,input().split())
parent=[ i for i in range(n+1)]
pq=[]
total=0

for _ in range(m):
    a,b,c=map(int,input().split())
    pq.append((c,a,b))
    total+=c
pq.sort()
print(kruskal(n,total,pq))
