from heapq import heappop, heapify, heappush
import sys
input = sys.stdin.readline
# 센티 제외 인구수, 센티 키, 횟수 제한
n,m,k = map(int, input().split())
arr = list(-1*int(input()) for _ in range(n)) # 최대 힙
heapify(arr)
cnt = k
ans = []
while arr and cnt:
    #print(arr)
    a = -1*heappop(arr) # 양수로
    #print(a, m)
    if a>=m:
        cnt-=1
        height = a//2
        if height>1:
            heappush(arr, -height)
        else:
            ans.append(-a)
        
def check(arr):
    for height in arr:
        if -height>=m:
            return False
    return True
total = ans+arr
if not check(total):
    print("NO")
    print(-1*min(total))
else:
    print("YES")
    print(k-cnt)
