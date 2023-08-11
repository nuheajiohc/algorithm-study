import sys
input = sys.stdin.readline

n = int(input())
arr_n = list(map(int, input().split()))
arr_n.sort()

m = int(input())
arr_m = tuple(map(int, input().split()))

def binary_search(num, start, end):
    while start <= end:
        mid = (start + end) // 2

        if arr_n[mid] == num:
            return 1

        elif arr_n[mid] > num:
            end = mid - 1

        else: # arr_n[mid] < num
            start = mid + 1

    return 0

for num in arr_m:
    print(binary_search(num, 0, n-1))