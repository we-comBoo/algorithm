from heapq import heappush, heappop, heapify

T = int(input())

for _ in range(T):
    n,m = map(int, input().split())
    lst = list(map(int, input().split()))
    
    heap = [-v for v in lst]
    arr = [[-v, idx] for idx,v in enumerate(lst)]
    
    ans=[0]*(n)
    heapify(heap)
    count = 1
    while heap:
        num = heap[0]
        first, firstIdx = arr.pop(0)
        if first!=num:
            arr.append([first, firstIdx])
        else:
            heappop(heap)
            ans[firstIdx] = count
            count+=1
    
    print(ans[m])