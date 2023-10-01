import sys
input=sys.stdin.readline

def solve(n,num):
    num.sort(reverse=True)
    result=0
    for i in range(n):
        if num[i]-i<=0:
            return result
        result+=num[i]-i
    return result

n=int(input())
num=[]
for i in range(n):
    num.append(int(input()))
print(solve(n,num))
