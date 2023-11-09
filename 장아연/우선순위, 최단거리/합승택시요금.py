INF = int(1e9)

# n : 지점 갯수, s : 출발 지점, a: a 도착지점, b: b 도착 지점
# fares : (지점1, 지점2, 비용)[]

def drawGraph(fares,n):
    graph = [[INF]*(n+1) for _ in range(n+1)]
    for i in range(n+1):
        graph[i][i]=0
    for a,b,c in fares:
        graph[a][b]=graph[b][a]=c
    return graph

def floyd(n, graph):
    for k in range(1,n+1):
        for s in range(1,n+1):
            for e in range(n+1):
                graph[s][e] = min(graph[s][e], graph[s][k]+graph[k][e])
    return graph
        
    
def solution(n, s, a, b, fares):
    graph = drawGraph(fares, n)
    graph = floyd(n,graph)
    ans = int(1e9)
    for mid in range(1,n+1):
        cost = graph[s][mid]+graph[mid][a]+graph[mid][b]
        ans = min(ans, cost)

    
    return ans
    
    
    