# https://www.acmicpc.net/problem/1026

import sys
input=sys.stdin.readline

n = int(input())
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))

answer=0
for _ in range(n):
    num1=max(arr1)
    arr1.remove(num1)
    num2=min(arr2)
    arr2.remove(num2)
    
    answer+=num1*num2
    
print(answer)