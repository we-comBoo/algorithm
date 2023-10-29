import sys
input=sys.stdin.readline

move=[[0,1],[0,-1],[1,0],[-1,0]]

def solve(x,y):
    st=[[x,y]]

    while st:
        a,b=st.pop()
        for dx,dy in move:
            nx=a+dx; ny=b+dy
            if 0<=nx<n and 0<=ny<m and MAP[nx][ny]==1:
                MAP[nx][ny]=0 #방문체크 대신 0으로 바꿔줌
                st.append([nx,ny])
    

t=int(input())
for _ in range(t):
    count=0
    m,n,k=map(int,input().split())
    MAP=[[0]*m for _ in range(n)]
    for _ in range(k):
        i,j=map(int,input().split())
        MAP[j][i]=1

    for i in range(n):
        for j in range(m):
            if MAP[i][j]==1:
                solve(i,j)
                MAP[i][j]=0
                count+=1
    print(count)
