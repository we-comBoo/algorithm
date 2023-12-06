import sys

input=sys.stdin.readline

name=input().rstrip()
check={}
for i in list(name):
    if i not in check:
        check[i]=1
    else:
        check[i]+=1
        
cnt=0
mid=''
for a,c in list(check.items()):
    if c%2==1:
        cnt+=1
        mid=a
        if cnt>1:
            print("I'm Sorry Hansoo")
            exit()
result=''
for a,c in sorted(check.items()):
    result+=(a*(c//2)) #앞부분만 만드는 것-> 사용되는 알파벳 수/2

result=result+mid+result[::-1]

print(result)
