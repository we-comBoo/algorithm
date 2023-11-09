"""
문제에서 시작지점이 주어져있지 않다. 
그래서 모든 지점을 시작지점으로 지정해서 돌리면 다른 언어에서는 시간이 적당할지 몰라도 파이썬의 경우는 시간초과가 뜬다. 
사실상 이 문제는 시작 지점에 관계없이 음의 사이클이 존재하는지만 판단하면 되는 문제다. 
따라서 모든 지점을 시작 지점으로 둘 필요가 없다. 시작지점은 아무곳이나 두고 dis[cur] != INF 조건을 삭제해주면 된다. 
dis[cur] != INF 조건이 들어간 이유는 bf 함수에 주어진 인자를 시작지점으로 했을 때 이 시작지점으로부터 이어진 노드의 최소 거리를 구하기 위함이었다.
(dis[start]=0 초기화 후 dis[cur] != INF조건이 있어야 시작지점부터 연결된 노드를 찾을 수 있기 때문) dis[cur] != INF 조건을 빼주게 되면 시작 지점과 관계없이 알고리즘이 진행되게 되는데 
이때 최단 거리 테이블인 dis는 시작지점으로부터의 최단 거리 테이블이라는 원래 의미를 갖지 않게 된다. 
그저 음수 싸이클의 존재 유무를 판단하는 테이블이 된다. 
"""


INF = int(1e9)

def isNegativeCycle(start):
    dist[start]=0
    for i in range(n):
        for start, end, cost in edges:
            if  dist[end]>dist[start]+cost:
                dist[end] = dist[start]+cost
                if i == n-1:
                    return True
    return False

# T : 테스트 케이스 갯수
T = int(input())
for _ in range(T):
    # n : 지점 수, m : 도로 수, w : 웜홀 갯수
    n,m,w = map(int, input().split())
    dist = [INF]*(n+1)
    
    edges = []
    # 양방향 : 지점1, 지점2, 걸리는 시간 : 도로
    for _ in range(m):
        v1, v2, cost = map(int, input().split())
        edges.append([v1,v2,cost])
        edges.append([v2,v1,cost])
        
        
    # 단방향 : 시작점, 도착점, 줄어드는 시간 : 웜홀
    for _ in range(w):
        start,end, cost = map(int, input().split())
        edges.append([start, end, -cost])

    
    if isNegativeCycle(1):
        print("YES")
    else:
        print("NO")

