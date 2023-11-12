def fill(n,fares):
    inf=10**8
    graph=[[inf]*(n+1) for _ in range(n+1)]
    
    for i in range(1,n+1):
        graph[i][i]=0
    for a,b,d in fares:
        graph[a][b]=d
        graph[b][a]=d
    return graph
        
def solution(n, s, a, b, fares):
    answer = 10**8
    graph=fill(n,fares)
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                #i->j 요금과 i->k->j 요금 중 최솟값을 찾아 갱신
                graph[i][j]=min(graph[i][j],graph[i][k]+graph[k][j])
    
    for i in range(1,n+1):
        #i까지 합동, + i->a 와 i->b 각각 합
        answer=min(graph[s][i]+graph[i][a]+graph[i][b],answer)
    return answer
