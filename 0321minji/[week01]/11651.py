import sys
input=sys.stdin.readline

def solve(n):
    num=[]
    for _ in range(n):
        num.append(list(map(int,input().split())))

    num.sort()
    num.sort(key=lambda x:x[1])

    for i in num:
        print(*i)
n=int(input())
solve(n)
