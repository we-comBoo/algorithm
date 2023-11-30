from collections import deque

start = ord("A")
able = [False]*26
arr = [[] for _ in range(26)]
cost = [0]*26
income = [0]*26
ans = [0]*26
result  = 0
while True:
 try:
     info = list(input().split())
     #print(info)
     num = ord(info[0]) - start
     time = int(info[1])
     
     able[num] = True
     cost[num] = time
     
     if len(info) == 3:
         for next in map(lambda x: ord(x) - start, info[2]):
             arr[num].append(next)
             income[next] += 1
 except:
     break

#print(able)
#print(arr)
#print(cost)
#print(income)
#print(ans)
#print(result)

q = deque()
for i in range(26):
 if income[i] == 0 and able[i]:
     ans[i] = cost[i]
     q.append((i, ans[i]))

while q:
 currNum, currCost = q.popleft()
 
 if not arr[currNum]:
     result = max(result, ans[currNum])
 
 for next in arr[currNum]:
     ans[next] = max(ans[next], currCost + cost[next])
     income[next] -= 1
     if income[next] == 0:
         q.append((next, ans[next]))

print(result)
