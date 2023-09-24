# https://www.acmicpc.net/problem/1431
# 백준 시리얼번호

import sys
input = sys.stdin.readline

n = int(input())
arr = list(list(input().strip()) for _ in range(n))

def getSum(lst):
    result=0
    for x in lst:
        if x.isnumeric():
            result+=int(x)
    return result
    
arr.sort(key=lambda x:(len(x),getSum(x),"".join(x)))


for i in arr:
    print(*i,sep="")