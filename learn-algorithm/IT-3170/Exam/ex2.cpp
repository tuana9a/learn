#include <iostream>
#include <algorithm>

using namespace std;

int n;

int X[16];
int class_weight[16];
int day_weight[16];
int min_best = INT32_MAX;

bool check(int v, int k)
{
    if (day_weight[v] + class_weight[k] > 6)
    {
        return false;
    }
    if (v >= min_best)
    {
        return false;
    }
    return true;
}

void solution()
{
    int last_day = 0;
    for (int i = 1; i <= n; i++)
    {
        last_day = max(last_day, X[i]);
        // cout << X[i] << endl;
    }
    min_best = min(min_best, last_day);
}

void Try(int k)
{
    for (int v = 1; v <= n; v++)
    {
        if (check(v, k))
        {
            X[k] = v;
            day_weight[v] += class_weight[k];
            if (k == n)
            {
                solution();
            }
            else
            {
                Try(k + 1);
            }
            day_weight[v] -= class_weight[k];
            X[k] = 0;
        }
    }
}

main()
{
    // ios_base::sync_with_stdio(false);
    // cin.tie(0);
    // freopen("input.txt", "r", stdin);
    // cin >> n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &class_weight[i]);
        // cin >> class_weight[i];
    }

    Try(1);
    cout << min_best << endl;
}