// #include <bits/stdc++.h>
#include <iostream>
using namespace std;

const int N_MAX = 100;

int n, max_load;
int min_best = 1e6;
int cur_load = 0;
int c_min = 1e6;
int weights[N_MAX][N_MAX];
bool visited[N_MAX];
int x[N_MAX];

void input()
{
    cin >> n >> max_load;

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
    // for (int i = 0; i <= 2 * n + 1; i++)
    // {
    //     for (int j = 0; j <= 2 * n + 1; j++)
    //     {
    //         cout << weights[i][j] << " ";
    //     }
    //     cout << endl;
    // }
}

bool check(int v, int cur_step)
{
    //check visited
    if (visited[v])
    {
        return false;
    }

    // cout << cur_load << " ";

    //check max load
    if (v <= n) //v<=n tức là đón thêm khách
    {
        if (cur_load + 1 > max_load)
        {
            return false;
        }
    }
    //check chưa đón khách mà đã trả
    else // v>n tức là điểm trả khách
    {
        if (!visited[v - n])
        {
            return false;
        }
    }
    //cat tia minimax
    int len = 0;
    x[cur_step] = v; //EXPLAIN: gán tại đây không cần revert
    for (int i = 0; i < cur_step; i++)
    {
        len += weights[x[i]][x[i + 1]];
    }
    len += c_min * (2 * n + 1 - cur_step);
    if (len >= min_best)
    {
        return false;
    }
    return true;
}

void solution()
{
    // cout << "sol:";
    // x[2 * n + 1] = 0;
    // for (int i = 0; i <= 2 * n + 1; i++)
    // {
    //     cout << x[i] << " ";
    // }

    int len = 0;
    for (int i = 0; i <= 2 * n; i++)
    {
        len += weights[x[i]][x[i + 1]];
    }
    // cout << "len:" << len;
    if (len < min_best)
    {
        min_best = len;
    }
    // cout << endl;
}

void Try(int k)
{
    for (int v = 1; v <= 2 * n; v++)
    {
        if (check(v, k))
        {
            x[k] = v;
            visited[v] = true;
            if (v <= n)
            {
                cur_load++;
            }
            else
            {
                cur_load--;
            }
            if (k == 2 * n)
            {
                solution();
            }
            else
            {
                Try(k + 1);
            }
            visited[v] = false;
            if (v <= n)
            {
                cur_load--;
            }
            else
            {
                cur_load++;
            }
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
