import sys
input=sys.stdin.readline
def find_parent(parent, x):
    if x != parent[x]:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

input = sys.stdin.readline
n, m = map(int, input().split())  
parent = list(range(n))

for i in range(m):
    x, y = map(int, input().split())
    if find_parent(parent, x) == find_parent(parent, y):  
        print(i + 1)
        exit(0)
    union(parent, x, y) 
else: 
    print(0)
