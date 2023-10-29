import sys
input=sys.stdin.readline

n=int(input())
w=[]
for _ in range(n):
    w.append(list(map(int,input().split())))
result=10**8
visit=[0]*n

def solve(s,h,temp,cnt):
    global result
    #답 갱신
    
    if cnt==n:
        if w[h][s]:
            temp+=w[h][s]
            result=min(result,temp)
        return

    if temp>result:
        return

    for i in range(n):
        if not visit[i] and w[h][i]:
            visit[i]=1#방문체크
            solve(s,i,temp+w[h][i],cnt+1)
            visit[i]=0

for i in range(n):
    visit[i]=1
    solve(i,i,0,1)
    visit[i]=0

print(result)
