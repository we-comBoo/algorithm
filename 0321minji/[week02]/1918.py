import sys
input=sys.stdin.readline

temp=list(map(str,input().strip()))
stack=[]
result=''

for i in temp:
    if i.isalpha():
        result+=i
    elif i=='(':
        stack.append(i)
        
    #연산자와 동일 우선순위일 경우 이전 연산자 우선
    elif i=='*' or i=='/':
        while stack and (stack[-1]=='*' or stack[-1]=='/'):
            result+=stack.pop()
        stack.append(i)

    #괄호 안에 들어있는 경우 + or -의 우선순위가 높음
    #그 외의 경우 이전 연산자 우선순위가 높기에 pop한 후에 append
    elif i== '+' or i=='-':
        while stack and stack[-1]!='(':
            result+=stack.pop()
        stack.append(i)
    elif i==')':
        while stack and stack[-1]!='(':
            result+=stack.pop()
        stack.pop()

while stack:
    result+=stack.pop()

print(result)
