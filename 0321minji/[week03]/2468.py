import sys
input=sys.stdin.readline

move=[[0,1],[0,-1],[1,0],[-1,0]]
def solve(a,b,v,visit):
    st=[[a,b]]
    while st:
        a,b=st.pop()
        visit[a][b]=1
        for dx,dy in move:
            nx=a+dx; ny=b+dy
            if 0<=nx<n and 0<=ny<n:
                if MAP[nx][ny]>v and not visit[nx][ny]:
                    st.append([nx,ny])
                    visit[nx][ny]=1
    

n=int(input())
MAP=[]
result=0

for _ in range(n):
    MAP.append(list(map(int,input().split())))

MAX=max(map(max,MAP))
for i in range(MAX):
    visit=[[0]*n for _ in range(n)]
    temp=0

    for j in range(n):
        for k in range(n):
            if MAP[j][k]>i and not visit[j][k]:
                solve(j,k,i,visit)
                temp+=1

    result=max(temp,result)
print(result)
