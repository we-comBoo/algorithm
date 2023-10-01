import sys
import re
input=sys.stdin.readline

def solve(n):
    serial=[]
    for _ in range(n):
        temp=input()
        nums=re.sub(r'[^0-9]','',temp)
        num=sum(list(map(int,nums)))
        serial.append([temp,len(temp),num])
    serial.sort(key=lambda x:(x[1],x[2],x[0]))

    for i in serial:
        print(i[0].rstrip())
      
n=int(input())
solve(n)
