import sys
input = sys.stdin.readline

def findParent(node, parent):
    if parent[node]!=node:
        parent[node]=findParent(parent[node], parent)
    return parent[node]

def findUnion(a,b, parent):
    a = findParent(a, parent)
    b = findParent(b, parent)
    # 진실을 아는 사람 우선으로
    if a in truth and b in truth:
        return
    elif a in truth:
        parent[b]=a
    elif b in truth:
        parent[a] = b
    else:
        # 더 작은 쪽을 조상으로
        if a<b:
            parent[b] = a
        else:
            parent[a] = b


# 사람 수 n, 파티수 m
n,m =map(int, input().split())
truth =list(map(int, input().split()[1:]))
party=[]
for _ in range(m):
    party.append(list(map(int, input().split()[1:])))
    
parent = [i for i in range(n+1)]

for p in party:
    for idx in range(len(p)-1):
        findUnion(p[idx], p[idx+1], parent)
answer=0
for p in party:
    flag = False
    for idx in range(len(p)):
        if findParent(p[idx], parent)   in truth:
            flag=True
            break
    if not(flag):
        answer+=1
print(answer)