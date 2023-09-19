#include <bits/stdc++.h>
using namespace std;

const int N_MAX = 100;
int n;

int c[N_MAX][N_MAX]; //EXPLAIN: mảng 2 chiều lưu khoảng cách giữa các node
int c_min = INT_MAX; //EXPLAIN: khoảng cách min trong toàn bộ tập dữ liệu khoảng cách

int x[N_MAX]; //EXPLAIN: quãng đường đi tới thời điểm hiện tại
int f;        //EXPLAIN: độ dài quãng đường đi tới hiện tại
int f_min;    //EXPLAIN: f_min tại thời điểm hiện tại

bool visited[N_MAX];

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            c[i][j] = -1;
        }
    }

    int m;
    cin >> m;
    for (int i = 1; i <= m; i++)
    {
        int x1, x2, dis;
        cin >> x1 >> x2;

        cin >> dis;
        c[x1][x2] = dis;
        if (x1 != x2)
        {
            if (dis < c_min)
            {
                c_min = dis;
            }
        }
    }
}

bool check(int v, int k)
{
    return !visited[v];
}

void updateBest()
{
    int dis = c[x[n]][x[1]];
    if (dis == -1)
    {
        return;
    }

    int f_current = f + dis;
    if (f_current < f_min)
    {
        f_min = f_current;
    }
}

vector<int> candidates(int cur)
{
    int t[N_MAX];
    int sz = -1;
    for (int v = 1; v < n; v++)
    {
        if (!visited[v])
        {
            //EXPLAIN: nếu đỉnh v chưa được thăm thì đưa vào mảng t
            t[sz] = v;
            sz++;
        }
    }
    for (int i = 0; i < sz; i++)
    {
        for (int j = i + 1; j < sz; j++)
        {
            if (c[cur][t[i]] > c[cur][t[j]])
            {
                int tmp = t[i];
                t[i] = t[j];
                t[j] = tmp;
            }
        }
    }
    vector<int> result;
    for (int i = 0; i < sz; i++)
    {
        result.push_back(t[i]);
    }
    return result;
}

void Try_v1(int k)
{
    for (int v = 1; v <= n; v++)
    {
        if (check(v, k))
        {
            int next_dis = c[x[k - 1]][v];
            if (next_dis != -1)
            {
                x[k] = v;
                visited[v] = true;
                f += next_dis; //khoảng cách giữa node trước đó và node đang xét
                if (k == n)
                {
                    updateBest();
                }
                else
                {
                    int g = f + c_min * (n - k + 1);
                    if (g < f_min)
                    {
                        Try_v1(k + 1);
                    }
                }
                visited[v] = false;
                f -= next_dis;
            }
        }
    }
}

void Try_v2(int k)
{
    vector<int> cands = candidates(x[k - 1]);
    for (int i = 0; i < cands.size(); i++)
    {
        int v = cands[i];
        x[k] = v;
        visited[v] = true;
        f += c[x[k - 1]][x[k]]; //khoảng cách giữa node trước đó và node đang xét
        if (k == n)
        {
            updateBest();
        }
        else
        {
            int g = f + c_min * (n - k + 1);
            if (g < f_min)
            {
                Try_v1(k + 1);
            }
        }
        visited[v] = false;
        f -= c[x[k - 1]][x[k]];
    }
}

int main()
{
    // freopen("TSP.txt", "r", stdin);
    input();
    for (int v = 1; v <= n; v++)
    {
        visited[v] = false;
    }
    x[1] = 1;
    visited[1] = true;
    f = 0;
    f_min = INT_MAX;
    Try_v1(2);
    cout << f_min;
    return 0;
}
