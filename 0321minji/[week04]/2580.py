sudoku=[list(map(int,input().split())) for _ in range(9)]
zero=[(i,j) for i in range(9) for j in range(9) if sudoku[i][j]==0]
def solve(i,j):
    num=[1,2,3,4,5,6,7,8,9]

    for k in range(9):#가로 세로 비교
        if sudoku[i][k] in num:
            num.remove(sudoku[i][k])
        if sudoku[k][j] in num:
            num.remove(sudoku[k][j])

    i//=3
    j//=3

    for x in range(i*3,i*3+3):
        for y in range(j*3, j*3+3):
            if sudoku[x][y] in num:
                num.remove(sudoku[x][y])
    return num

putout=False #출력 여부 확인

def func(index):
    global putout
    
    if index==len(zero): #0까지 숫자 다 채운 후
        for row in sudoku:
            for n in row:
                print(n, end=" ")
            print()
        putout=True
        return
    
    if putout==False:
        (i,j)=zero[index]
        num=solve(i,j)

        for number in num:
            sudoku[i][j]=number
            func(index+1)
            sudoku[i][j]=0

func(0)
