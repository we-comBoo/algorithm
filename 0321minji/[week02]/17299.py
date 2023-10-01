import sys
from collections import Counter

input=sys.stdin.readline

stack=[]
n=int(input())
a=list(input().split())
cnt=Counter(a)

f=[cnt[num] for num in a]
ans=[-1]*n

stack.append(0)

i=1
while stack and i<n:
    while stack and f[stack[-1]]<f[i]:
        ans[stack[-1]]=a[i]
        stack.pop()
    stack.append(i)
    i+=1

for num in ans:
    print(num, end=' ')
