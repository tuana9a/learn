#include <iostream>
#include <algorithm>

using namespace std;

int N;
int X[6];
/** 
 * X[0] C
 * X[1] T
 * X[2] D
 * X[3] L
 * X[4] G
 * X[5] U
*/

bool visisted[10];
int min_best = 0;

bool check(int v, int k)
{
    if (visisted[v])
    {
        return false;
    }
    if (k == 0 || k == 1)
    {
        if (v == 0)
        {
            return false;
        }
    }
    return true;
}

void solution()
{
    //CTDLGT + TTUD = N
    // cout << "reach" << endl;
    int C = X[0];
    int T = X[1];
    int D = X[2];
    int L = X[3];
    int G = X[4];
    int U = X[5];
    int total = C * 100000 + T * 10000 + D * 1000 + L * 100 + G * 10 + T + T * 1000 + T * 100 + U * 10 + D;
    if (total == N)
    {
        min_best++;
    }
}

void Try(int k)
{
    for (int v = 0; v <= 9; v++)
    {
        if (check(v, k))
        {
            X[k] = v;
            visisted[v] = true;
            if (k == 5)
            {
                solution();
            }
            else
            {
                Try(k + 1);
            }
            visisted[v] = false;
        }
    }
}

main()
{
    // ios_base::sync_with_stdio(false);
    // cin.tie(0);
    // freopen("input.txt", "r", stdin);
    cin >> N;
    Try(0);
    cout << min_best << endl;
}