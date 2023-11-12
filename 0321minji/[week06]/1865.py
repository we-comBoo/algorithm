import sys
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    flag=False
    n,m,w=map(int,input().split())
    road=[[] for _ in range(n+1)]
    for _ in range(m):
        s,e,t=map(int,input().split())
        road[s].append((e,t))
        road[e].append((s,t))
    for _ in range(w):
        s,e,t=map(int,input().split())
        road[s].append((e,-t))

    #초기화
    dis=[10**9]*(n+1)
    #i를 시작점으로하여 탐색 진행
    for i in range(1,n+1):
        for j in range(1,n+1):
            for e, wei in road[j]:
                if(dis[e]>wei+dis[j]):
                    dis[e]=wei+dis[j]
                    #갱신했고 시작점으로 다시 돌아온거면
                    if i==n:
                        flag=True
                        break
    if not flag:
        print('NO')
    else:
        print('YES')
