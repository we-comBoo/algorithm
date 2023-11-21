import sys, heapq
input=sys.stdin.readline

n,m,k=map(int,input().split())
bear=[]
for _ in range(k):
    bear.append(list(map(int,input().split())))
bear=sorted(bear,key=lambda x:(x[1],x[0]))
#도수 레벨 순으로 정렬

p=0
pq=[]
answer=-1
for i in bear:
    p+=i[0]
    heapq.heappush(pq,i[0])

    if len(pq)==n:
        if p>=m:
            answer=i[1]
            break
        else:
            p-=heapq.heappop(pq)

print(answer)
