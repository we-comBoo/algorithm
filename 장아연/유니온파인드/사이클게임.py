import sys
input = sys.stdin.readline

def findParent(node, parent):
    if parent[node]!=node:
        parent[node]=findParent(parent[node], parent)
    return parent[node]

def findUnion(a,b, parent):
    a = findParent(a, parent)
    b = findParent(b, parent)
    # 더 작은 쪽을 조상으로
    if a<b:
        parent[b] = a
    else:
        parent[a] = b



n,m =map(int, input().split())
parent = [i for i in range(n)]
for t in range(1,m+1):
    a,b =map(int, input().split())
    if findParent(a, parent)==findParent(b, parent):
        print(t)
        exit()
    findUnion(a,b,parent)

if t == m:
    print(0)