#include <bits/stdc++.h>
using namespace std;

const int N_MAX = 100;
int N;
int cnt;
int x[8];
bool visited[N_MAX];

//EXPLAIN:
/*  
    x[1]: I
    x[2]: C
    x[3]: T
    x[4]: K
    x[5]: H
    x[6]: U
    x[7]: S
*/

bool check(int v, int k)
{
    return !visited[v];
}
bool checkSolution()
{
    int total = x[1] * 100 + x[2] * 10 + x[3] - (x[4] * 100 + 62) + x[5] * 1000 + x[6] * 100 + x[7] * 10 + x[3];
    return total == N;
}
void printSolution()
{
    cout << "ICT − K62 + HUST = N" << endl;
    cout << x[1] << x[2] << x[3] << " - " << x[4] << "62"
         << " + " << x[5] << x[6] << x[7] << x[3] << " = " << N << endl;
}

void Try(int k)
{
    for (int value = 1; value <= 9; value++)
    {
        if (check(value, k))
        {
            x[k] = value;
            visited[value] = true;
            if (k == 7)
            {
                // printSolution();
                // cout << "T=" << T << endl;
                if (checkSolution())
                {
                    ++cnt;
                    // printSolution();
                }
            }
            else
            {
                Try(k + 1);
            }
            visited[value] = false;
            x[k] = 0;
        }
    }
}

int main()
{
    cin >> N;
    Try(1);
    cout << cnt;
    return 0;
}
