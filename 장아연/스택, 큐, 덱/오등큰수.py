# https://www.acmicpc.net/problem/17299

from collections import Counter
import sys
input = sys.stdin.readline


n = int(input())
arr = list(map(int, input().split()))
cnt = Counter(arr)
res = [-1]*n
stack = [0]


for i in range(1,n):
    while stack and cnt[arr[stack[-1]]]<cnt[arr[i]]:
        res[stack.pop()]=arr[i]

    stack.append(i)


print(*res)