import sys
input=sys.stdin.readline

def solve(n):
    #점수 저장할 리스트
    score=[]
    result=1
    for _ in range(n):
        num=list(map(int,input().rstrip().split()))
        score.append(num)
    
    score.sort()
    temp=score[0][1]

    for i in range(1,n):
        if temp>score[i][1]:
            result+=1
            temp=score[i][1]
    print(result)


t=int(input())
for _ in range(t):
    n=int(input())
    solve(n)
