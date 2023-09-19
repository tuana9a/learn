#include <iostream>
#include <cstdio>
#define NMAX 2000000

using namespace std;
int n, s[NMAX], t[NMAX], F[NMAX], F2[NMAX];

void input()
{
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
    {
        scanf("%d %d", &s[i], &t[i]);
    }
}

void slove()
{
    for (int i = 1; i <= n; i++)
    {
        F[t[i]] = max(F[t[i]], t[i] - s[i]);
        //EXPLAIN: công việc dài nhất kết thúc tại i
    }
    for (int i = 1; i <= NMAX; i++)
    {
        F2[i] = max(F2[i - 1], F[i]);
        //EXPLAIN: công việc dài nhất từ i trở về trước;
        // tính bằng max của thằng trước nó và qua F độ dài max kết thúc tại i
    }
    int best = 0;
    for (int i = 1; i <= n; i++)
    {
        best = max(best, t[i] - s[i] + F2[s[i] - 1]);
        //EXPLAIN: max tính bằng max của best và check của task hiện tại cộng tới max của công việc
        // mà thời điểm nó kết thúc ngay trước nó
    }

    cout << best << endl;
}

main()
{
    // freopen("input.txt", "r", stdin);
    input();
    slove();
}
