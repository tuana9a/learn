// #include <bits/stdc++.h>
#include <iostream>
using namespace std;

const int N_MAX = 100;

int n;
int min_best = 1e6;
int c_min = 1e6;
int weights[N_MAX][N_MAX];
bool visited[N_MAX];
int x[N_MAX];

void input()
{
    cin >> n;

    for (int i = 0; i <= 2 * n; i++)
    {
        for (int j = 0; j <= 2 * n; j++)
        {
            int c;
            cin >> c;
            weights[i][j] = c;
            if (c != 0)
            {
                c_min = min(c_min, c);
            }
        }
    }
    // cout << c_min << endl;
    // cout << "input complete" << endl;
    // for (int i = 0; i < m; i++)
    // {
    //     for (int j = 0; j < m; j++)
    //     {
    //         cout << weights[i][j] << " ";
    //     }
    //     cout << endl;
    // }
}

bool check(int v, int k)
{
    if (visited[v])
    {
        return false;
    }
    int len = 0;
    x[k] = v; //EXPLAIN: gán tại đây không cần revert
    for (int i = 0; i < k; i++)
    {
        len += weights[x[i]][x[i + 1]];
    }
    len += c_min * (2 * n + 1 - k);
    // cout << len << endl;
    if (len >= min_best)
    {
        return false;
    }
    return true;
}

void solution()
{
    x[2 * n + 1] = 0;
    // for (int i = 0; i < 2 * n + 2; i++)
    // {
    //     cout << x[i] << " ";
    // }
    // cout << endl;

    int len = 0;
    for (int i = 0; i <= 2 * n; i++)
    {
        len += weights[x[i]][x[i + 1]];
    }
    // cout << "len=" << len << endl;
    if (len < min_best)
    {
        min_best = len;
    }
}

void Try(int k)
{
    for (int v = 1; v <= n; v++)
    {
        if (check(v, k))
        {
            x[k] = v;
            x[k + 1] = v + n;
            visited[v] = true;
            visited[v + n] = true;
            if (k == 2 * n - 1)
            {
                solution();
            }
            else
            {
                Try(k + 2);
            }
            visited[v] = false;
            visited[v + n] = false;
        }
    }
}

int main()
{
    input();
    x[0] = 0;
    Try(1);
    cout << min_best << endl;
    return 0;
}
