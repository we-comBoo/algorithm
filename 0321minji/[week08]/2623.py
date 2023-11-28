import sys
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[[] for _ in range(n+1)]
indegree=[0]*(n+1)

for _ in range(m):
    temp=list(map(int,input().split()))
    for s in range(1,temp[0]):
        graph[temp[s]].append(temp[s+1])
        indegree[temp[s+1]]+=1

que=[]
res=[]
for i in range(1,n+1):
    if indegree[i]==0:
        que.append(i)
while que:
    t=que.pop()
    res.append(t)
    for i in graph[t]:
        indegree[i]-=1

        if indegree[i]==0:
            que.append(i)

if len(res)!=n:
    print(0)
else:
    print(*res,sep='\n')
