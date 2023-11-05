from heapq import heapify, heappush, heappop
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    row = list(map(int, input().split()))

    for e in row:
        if len(arr)>n:
            heappop(arr)
        heappush(arr, e)

ans = -1
heap = list(map(lambda x:x*-1,arr))
heapify(heap)

for _ in range(n):    
    ans=-heap[0]
    heappop(heap)
print(ans)

    