#include <bits/stdc++.h>
#include <limits.h>

using namespace std;

int n;
int numOfConditions;
int numOfSolution = 0;
int solution[1000];
int visited[1000];
int conditions[1000][2];

bool notVisit(int value)
{
    return visited[value] == 0;
}
bool checkSolution()
{
    for (int i = 1; i <= numOfConditions; i++)
    {
        int value1 = conditions[i][0];
        int value2 = conditions[i][1];
        if (visited[value1] > visited[value2])
        {
            return false;
        }
    }
    numOfSolution++;
    return true;
}
void printSolution()
{
    for (int i = 1; i <= n; i++)
    {
        cout << solution[i] << " ";
    }
    cout << endl;
}

void Try(int k)
{
    // cout << k << endl;
    for (int value = 1; value <= n; value++)
    {
        if (notVisit(value))
        {
            solution[k] = value;
            visited[value] = k;
            if (k == n)
            {
                // printSolution();
                if (checkSolution())
                {
                    printSolution();
                }
            }
            else
            {
                Try(k + 1);
            }
            visited[value] = 0;
        }
    }
}

int main()
{
    cin >> n >> numOfConditions;
    for (int i = 1; i <= numOfConditions; i++)
    {
        cin >> conditions[i][0] >> conditions[i][1];
    }
    for (int i = 1; i <= 1000; i++)
    {
        visited[i] = 0;
    }

    Try(1);
    cout << numOfSolution;
    return 0;
}
