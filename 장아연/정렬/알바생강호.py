# https://www.acmicpc.net/problem/1758
#  원래 주려고 생각했던 돈 - (받은 등수 - 1)  최대로 만들기
# 원래 주려고 한 돈은 최대로, 받는 등수는 최소로 ~

import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
answer=0
c =sorted([int(input()) for _ in range(n)], reverse=True)
#print(arr, lst)
#print(c)

for idx, value in enumerate(c,1):
    score = value-(idx-1)
    if score<0: 
        score=0
    answer+=score

        
print(answer)
        