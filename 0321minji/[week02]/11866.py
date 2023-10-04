import sys
input=sys.stdin.readline

n,k=map(int,input().split())

result=[]
temp=[i for i in range(1,n+1)]

#원형큐
#index 이용 : (i+k-1)%len

index=0
while n:
    index=(index+k-1)%n
    result.append(temp.pop(index))
    n-=1

print("<",end='')
print(*result,sep=", ",end='')
print(">")
    
