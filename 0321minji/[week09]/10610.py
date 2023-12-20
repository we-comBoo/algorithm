n=list(input())
n.sort(reverse=True)

n=int("".join(n))
if n%30==0:
    print(n)
else:
    print(-1)

