#include <iostream>
#include <cstdio>

#define MODU 1000000007
#define NMAX 102
#define MMAX 502

using namespace std;

int n, m, a[NMAX], f[NMAX][MMAX];

void input()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }
}

void slove()
{
    f[0][0] = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            for (int k = 1; k <= j; k++)//thêm k cửa hàng vào nhà phân phối thứ i
            {
                if (k % a[i] == 0)//check các k chia hết cho ai
                {
                    f[i][j] = (f[i][j] + f[i - 1][j - k]) % MODU;
                }
            }
        }
    }
    cout << f[n][m] << endl;
}

main()
{
    // freopen("input.txt", "r", stdin);
    input();
    slove();
}