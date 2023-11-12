import sys
input=sys.stdin.readline

def solve():
    n, m=map(int,input().split())
    index=[0]*(n)
    index[m]=1

    temp=list(map(int,input().split()))
    count=0

    while True:
        #temp 맨 앞 요소가 가장 큰 값일 경우 = 맨 앞 요소가 출력되는 경우
        if  temp[0]==max(temp):
            temp.remove(temp[0])
            count+=1
            # 그 요소가 우리가 찾는 값인 경우
            if(index[0]==1):
                print(count)
                break
            else:
                index.remove(index[0])
        #그 외의 경우 앞에서 빼서 뒤에 추가       
        else:
            temp.append(temp[0])
            temp.remove(temp[0])
            index.append(index[0])
            index.remove(index[0])
t=int(input())
for _ in range(t):
    solve()
