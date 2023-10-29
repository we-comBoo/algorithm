import sys
input=sys.stdin.readline

move=[[0,1],[0,-1],[-1,0],[1,0]]

def solve(a,b,v):
    st=[[a,b]]
    temp=0
    MAP[a][b]=-1
    
    while(st):
        a,b=st.pop()
        temp+=1
        for dx,dy in move:
            nx=a+dx; ny=b+dy
            if 0<=nx<n and 0<=ny<n and MAP[nx][ny]==v:
                st.append([nx,ny])
                MAP[nx][ny]=-1
    return temp

n=int(input())
MAP=[]

for _ in range(n):
    MAP.append(list(map(int,input().rstrip())))

result=0
cnt=[]
for i in range(n):
    for j in range(n):
        if MAP[i][j]>0:
            cnt.append(solve(i,j,MAP[i][j]))
            result+=1
print(result)
cnt.sort()
print(*cnt,sep='\n',end='')
