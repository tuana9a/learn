#include <iostream>
#include <algorithm>
using namespace std;

int T;
const int T_MAX = 1e4;
long long STORAGE_N[T_MAX];
long long STORAGE_X[T_MAX][1000];
long long STORAGE_Y[T_MAX][1000];
long long SOLUTION[T_MAX];

void printReach()
{
    cout << "reach" << endl;
}

void printInput()
{
    for (int i = 0; i < T; i++)
    {
        long n = STORAGE_N[i];
        for (int j = 0; j < n; j++)
        {
            cout << STORAGE_X[i][j];
        }
        cout << endl;
        for (int j = 0; j < n; j++)
        {
            cout << STORAGE_Y[i][j];
        }
        cout << endl;
    }
}

void input()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        int n;
        cin >> n;
        STORAGE_N[i] = n;
        for (int j = 0; j < n; j++)
        {
            cin >> STORAGE_X[i][j];
        }
        for (int j = 0; j < n; j++)
        {
            cin >> STORAGE_Y[i][j];
        }
    }

    for (int i = 0; i < T; i++)
    {
        long n = STORAGE_N[i];
        sort(STORAGE_X[i], STORAGE_X[i] + n);
        sort(STORAGE_Y[i], STORAGE_Y[i] + n, greater<long long>());
    }

    for (int i = 0; i < T; i++)
    {
        SOLUTION[i] = INT32_MAX;
    }
}

void Try(int current_case)
{
    long long n = STORAGE_N[current_case];
    // cout << k << " " << n << endl;
    long long total = 0;
    for (int j = 0; j < n; j++)
    {
        total += STORAGE_X[current_case][j] * STORAGE_Y[current_case][j];
    }
    SOLUTION[current_case] = total;
}

int main(int argc, char const *argv[])
{
    input();
    // printInput();

    for (int current_case = 0; current_case < T; current_case++)
    {
        Try(current_case);
    }

    for (int i = 0; i < T; i++)
    {
        cout << "Case #" << i + 1 << ": " << SOLUTION[i] << endl;
    }

    return 0;
}
