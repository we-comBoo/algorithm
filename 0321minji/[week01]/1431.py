###
#정렬 조건
#1. 길이 짧은 순
#2. 동일 길이 -> 숫자 합
#3. 사전순
###########
# 각 input에 대해 길이, 숫자합을 구해 추가 후 lambda를 통해 우선순위 부여 후 정렬

import sys
import re
input=sys.stdin.readline

def solve(n):
    serial=[]
    for _ in range(n):
        temp=input()
        #리스트에서 숫자만 고르기
        nums=re.sub(r'[^0-9]','',temp)
        #형변환 후 합
        num=sum(list(map(int,nums)))
        serial.append([temp,len(temp),num])
    serial.sort(key=lambda x:(x[1],x[2],x[0]))

    for i in serial:
        print(i[0].rstrip())
      
n=int(input())
solve(n)
