import sys
input=sys.stdin.readline

num=0
while True:
    temp=list(input().rstrip())
    if temp.count("-")>=1:
        break

    result=0
    if temp[0]=='}':
        result+=1
    if temp[-1]=='{':
        result+=1

    count=1
    for i in range(1,len(temp)-1):
        if temp[i]=='{':
            count+=1
        else:
            count-=1
        if count<0:
            result+=1
            count=1

    if count!=0:
        result+=(count-1)//2
    num+=1
    print(num,'. ',int(result),sep='')
