#include <iostream>
#include <vector>
using namespace std;

int n, m, M;
const int N_MAX = 20000;
bool solved[N_MAX];
int arr[N_MAX];
int mem[N_MAX];
vector<int> mem_S[N_MAX];
int result = 0;

void printInput()
{
    cout << n << m << M << endl;
    for (int i = 0; i < n; i++)
    {
        cout << arr[i];
    }
}

void println(int v)
{
    cout << v << endl;
}

void input()
{
    cin >> n >> m >> M;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
}

int main(int argc, char const *argv[])
{
    input();
    
    for (int i = 0; i < n; i++)
    {
        int total = 0;
        for (int j = i; j < n; j++)
        {
            total += arr[j];
            if (total >= m && total <= M)
            {
                result++;
            }
        }
    }

    cout << result;
    return 0;
}
