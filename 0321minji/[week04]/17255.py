import sys
input=sys.stdin.readline
n = input().strip()
cnt = 0

def dfs(num):
    global cnt
    if len(n) == 1:
        cnt +=1
        return
    L = set(list(num))
    if len(L) == 1:
        cnt+=1
        return
    else:
        dfs(num[1:])
        dfs(num[:-1])


dfs(n)
print(cnt)
