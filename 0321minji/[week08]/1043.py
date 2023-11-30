import sys
input=sys.stdin.readline


def find(parent,x):
    if x!=parent[x]:
        parent[x]=find(parent,parent[x])
    return parent[x]

def union(parent,a,b,mem):
    a=find(parent,a)
    b=find(parent,b)

    if a in mem and b in mem:
        return

    if a in mem:
        parent[b]=a
    elif b in mem:
        parent[a]=b

    else:
        if a<b:
            parent[b]=a
        else:
            parent[a]=b

    
n,m=map(int,input().split())

b=list(map(int,input().split()))[1:]
##아는 사람 

g=[]
parent=list(range(n+1))

for i in range(m):
    temp=list(map(int,input().split()))
    people=temp[1:]
    
    for j in range(temp[0]-1):
        union(parent,people[j],people[j+1],b)
    g.append(temp[1:])
    
    
result=0

for i in g:
    for j in range(len(i)):
        if find(parent,i[j]) in b:
            break
    else:
        result+=1

print(result)
