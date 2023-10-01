import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr=[i for i in range(1, n+1)]

#print(arr)
idx=0
answer=[]

while arr:
    idx=(idx+m-1)%len(arr)
    answer.append(arr[idx])
    arr.pop(idx)

      
result ="<"+", ".join(list(map(str,answer)))+">"
print(result)