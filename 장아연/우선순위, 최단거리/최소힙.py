from heapq import heappush, heappop
import sys
input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    cmd = int(input())
    if cmd==0:
        if not(heap):
            print(0)
        else:
            item = heap[0]
            heappop(heap)
            print(item)
    else:
        heappush(heap, cmd)