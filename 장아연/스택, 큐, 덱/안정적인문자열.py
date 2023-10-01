import sys
input = sys.stdin.readline


def solution(arr):
    stack=[]
    
    count=0
    for idx in range(len(arr)):
        if arr[idx]=="}" and not stack:
            count+=1
            stack.append("{")
        elif arr[idx]=="}" and stack:
            stack.pop()
        else:
            stack.append("{")
    count+=len(stack)//2
    return count

answer=[]
while True:
    arr=list(input().strip()) 
    if "-" in arr:
        break
    answer.append(solution(arr))
    
for idx, v in enumerate(answer,1):
    print(idx,". ",v,sep="")
        