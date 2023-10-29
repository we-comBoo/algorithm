from itertools import permutations
import sys
input=sys.stdin.readline

a,b,c=map(list,input().split())
num=[i for i in range(10)]
match={}

alpha=list(set(a+b+c))
if len(alpha)>10:
    print('NO')
    exit()

def solve():
    n1=n2=n3=0
    for i in a:
        n1*=10
        n1+=match[i]
    for i in b:
        n2*=10
        n2+=match[i]
    for i in c:
        n3*=10
        n3+=match[i]
    return n1+n2==n3

#순열 이용
for i in permutations(num,len(alpha)):
    for j in range(len(alpha)):
        match[alpha[j]]=i[j]
    #print(match)
    if solve():
        print('YES')
        exit()
print('NO')
    
