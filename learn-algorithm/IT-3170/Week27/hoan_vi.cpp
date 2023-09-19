#include <bits/stdc++.h>
using namespace std;

int solution[1000];
int n;
bool visited[1000];

bool checkVisit(int value)
{
    return !visited[value];
}
void printSolution()
{
    for (int i = 0; i < n; i++)
    {
        cout << solution[i] << " ";
    }
    cout << endl;
}

void Try(int k)
{
    // cout << k << endl;
    for (int value = 0; value < n; value++)
    {
        if (checkVisit(value))
        {
            solution[k] = value;
            visited[value] = true;
            if (k == n - 1)
            {
                printSolution();
            }
            else
            {
                Try(k + 1);
            }
            visited[value] = false;
        }
    }
}

int main()
{
    // for_each(solution, solution + 1000, [](int value) {
    //     cout << value << endl;
    // });
    // for_each(visited, visited + 1000, [](int value) {
    //     cout << value << endl;
    // });
    cin >> n;
    // n = 3;
    Try(0);
    return 0;
}
