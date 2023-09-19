#include <iostream>
using namespace std;

const int N_MAX = 31;

int m, n; //m: so giao vien| n: so mon hoc
int can_be_teach[N_MAX][N_MAX];
bool conflict[N_MAX][N_MAX];

int teacher_load[N_MAX];
int result_best = 1e6;
int x[N_MAX];
bool visited[N_MAX];

void input()
{
    cin >> m >> n;
    for (int giaovien = 1; giaovien <= m; giaovien++)
    {
        int soluong;
        cin >> soluong;
        for (int j = 1; j <= soluong; j++)
        {
            int monhoc;
            cin >> monhoc;
            can_be_teach[monhoc][giaovien] = 1;
        }
    }
    int temp;
    cin >> temp;
    for (int i = 1; i <= temp; i++)
    {
        int mon1, mon2;
        cin >> mon1 >> mon2;
        conflict[mon1][mon2] = true;
    }
}

bool check(int gv, int mh)
{
    for (int i = 1; i < mh; i++)
    {
        if (conflict[i][mh] && x[i] == gv)
        {
            return false;
        }
    }
    if ((teacher_load[gv] + 1) >= result_best)
    {
        return false;
    }
    return true;
}

void solution()
{
    int max_load = teacher_load[1];
    for (int i = 1; i <= m; i++)
    {
        if (teacher_load[i] > max_load)
        {
            max_load = teacher_load[i];
        }
    }
    if (max_load < result_best)
    {
        result_best = max_load;
    }
}

void Try(int mh)
{
    for (int gv = 1; gv <= N_MAX; gv++)
    {
        if (can_be_teach[mh][gv])
        {
            if (check(gv, mh))
            {
                x[mh] = gv;
                visited[gv] = true;
                teacher_load[gv]++;
                if (mh == n)
                {
                    solution();
                }
                else
                {
                    Try(mh + 1);
                }
                // recover
                teacher_load[gv]--;
                visited[gv] = false;
            }
        }
    }
}

int main()
{
    input();
    for (int i = 1; i <= m; i++)
    {
        teacher_load[i] = 0;
    }
    Try(1);
    if (result_best == 0 || result_best == 1e6)
    {
        cout << -1;
    }
    else
    {
        cout << result_best;
    }
    return 0;
}
