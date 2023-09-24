# https://www.acmicpc.net/problem/1946
# 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 
# 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다

import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    arr.sort()
    # 가장 서류 심사 높은 사람의 면접순위 = best_t2
    best_t1, best_t2 = arr[0]
    answer=[[best_t1,best_t2]]
    #print("arr",answer)
    
    for scores in arr: 
        # 서류 순위가 오름차순으로 정렬되어 있으므로 (이미 서류 순위는 현재 값이 더 낮음)
        # 최고 면접 순위보다 현재 면접 순위가 높아야 함 + 더 높은 순위 나오면 갱신
        if scores[1]<best_t2:
            answer.append(scores)
            best_t2 = scores[1]
               
    #print(answer)       
    print(len(answer))
        


"""
1
10
1 10
2 9
3 8
4 7
5 6
6 5
7 4
8 3
9 2
10 1

# Answer
10
"""

"""
1
5
1 5
2 3
3 4
4 2
5 1

## Answer
4
"""