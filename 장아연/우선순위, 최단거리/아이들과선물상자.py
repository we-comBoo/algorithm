from heapq import heappush, heappop,heapify

# heapify : 기존 리스트를 heapq로 변환

n,m = map(int, input().split())
gift = list(map(int, input().split()))
gift = list(map(lambda x:x*-1, gift))
child = list(map(int, input().split()))

heapify(gift)

flag = True
while child:
    item = -1*gift[0]
    person = child[0]
    rest = item-person
    if rest<0:
        flag = False
        break
    else:
        heappop(gift)
        child.pop(0)
        
        if rest>0:
            heappush(gift, -rest)
        #print(gift, item, person, rest)
if flag:
    print(1)
else:
    print(0)


