#include <iostream>
using namespace std;

const int N_MAX = 2e6;
int n;

int arr[N_MAX];
int mem[N_MAX];
int solved[N_MAX];

int answer = -1e6;

void input()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }
    for (int i = 1; i <= n; i++)
    {
        solved[i] = false;
    }
}

int DP(int i)
{
    if (i == 1)
    {
        //EXPLAIN: bai toan con nho nhat
        mem[1] = arr[1];
        solved[1] = true;
        return arr[1];
    }

    if (solved[i])
    {
        //EXPLAIN: bai toan con da co loi giai
        return mem[i];
    }

    mem[i] = max(DP(i - 1) + arr[i], arr[i]);
    solved[i] = true;
    // answer = max(result, answer);
    return mem[i];
}

int main(int argc, char const *argv[])
{
    input();
    // DP(n);

    answer = DP(1);
    for (int i = 2; i <= n; i++)
    {
        answer = max(DP(i), answer);
    }
    cout << answer;
    return 0;
}
