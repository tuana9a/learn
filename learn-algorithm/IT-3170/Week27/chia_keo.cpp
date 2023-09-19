#include <bits/stdc++.h>
using namespace std;

int solution[1000];
int n;     //EXPLAIN: số lượng biến
int T = 0; //EXPLAIN: tổng tích lũy
int M;     //EXPLAIN: tổng kết quả cho trước

bool check(int value, int k)
{
    return true;
}
void printSolution()
{
    for_each(solution, solution + n, [](int value) {
        cout << value << " ";
    });
    cout << "= " << M << endl;
}

void Try(int k)
{
    // cout << k << endl;
    // printSolution();

    //EXPLAIN: n-k do tổng tối thiểu của các số còn lại
    // vì là số nguyên dương nên nhỏ nhất là 1 và còn n-k số còn lại
    int maxValue = M - (T + (n - k - 1));//vì k chạy từ 0 nên (k+1)
    for (int value = 1; value <= maxValue; value++)
    {
        if (check(value, k))
        {
            solution[k] = value;
            T += value;
            if (k == n - 1)
            {
                // printSolution();
                // cout << "T=" << T << endl;
                if (T == M)
                {
                    printSolution();
                }
            }
            else
            {
                Try(k + 1);
            }
            T -= value;
            solution[k] = 0;
        }
    }
}

int main()
{
    cin >> n >> M;
    // n = 3;
    // M = 10;
    Try(0);
    return 0;
}
