#include <iostream>
using namespace std;

int T;
const int T_MAX = 1e4;
int STORAGE_N[T_MAX];
int STORAGE_X[T_MAX][1000];
int STORAGE_Y[T_MAX][1000];
int SOLUTION[T_MAX];

void printReach()
{
    cout << "reach" << endl;
}

void printInput()
{
    for (int i = 0; i < T; i++)
    {
        int n = STORAGE_N[i];
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

int current_case;
int Y[1000];
bool visitedY[100000];

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
        SOLUTION[i] = 1e9;
    }

    for (int i = 0; i < 100000; i++)
    {
        visitedY[i] = false;
    }
}

bool checkY(int v, int k)
{
    return !visitedY[v];
}

void updateResult()
{
    int total = 0;
    int n = STORAGE_N[current_case];
    for (int i = 0; i < n; i++)
    {
        total += STORAGE_X[current_case][i] * Y[i];
    }
    // cout << current_case << endl;
    SOLUTION[current_case] = min(SOLUTION[current_case], total);
}

void Try_hoanviY(int k)
{
    
    int n = STORAGE_N[current_case];
    // cout << k << " " << n << endl;
    for (int i = 0; i < n; i++)
    {
        int v = STORAGE_Y[current_case][i];
        if (checkY(i, k))
        {
            visitedY[i] = true;
            Y[k] = v;

            // cout << k << " " << n << endl;
            if (k == n - 1)
            {
                // cout << k << " " << n << endl;
                updateResult();
            }
            else
            {
                Try_hoanviY(k + 1);
            }
            visitedY[i] = false;
        }
        // cout << k << " " << n << endl;
    }
}

int main(int argc, char const *argv[])
{
    input();
    for (current_case = 0; current_case < T; current_case++)
    {
        Try_hoanviY(0);
    }
    for (int i = 0; i < T; i++)
    {
        cout << "Case #" << i + 1 << ": " << SOLUTION[i] << endl;
    }

    return 0;
}
