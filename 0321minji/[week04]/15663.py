import sys
input=sys.stdin.readline

n,m=map(int,input().split())
num=sorted(list(map(int,input().split())))
visit=[0]*n
result=[]
temp=[]

def bt(temp):
    if m==len(temp):
        print(*temp)
        return
    j=0
    for i in range(n):
        if not visit[i] and j!=num[i]:
            temp.append(num[i])
            visit[i]=1
            j=num[i]
            bt(temp)
            visit[i]=0
            temp.pop()
bt(temp)
