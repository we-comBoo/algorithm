import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

def solve(tree,s,p):
    for i in tree[s]:
        if p[i]==0:
            p[i]=s
            solve(tree,i,p)


n=int(input())
tree=[[] for _ in range(n+1)]

for i in range(n-1):
    a,b=map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

p=[0]*(n+1)
solve(tree,1,p)

for i in range(2,n+1):
    print(p[i])
