#include <iostream>
#include <algorithm>

using namespace std;

/**
 * ý tưởng thử từng khoảng cách min , max sau đó lấy ở giữa, rồi lại lấy ở giữa
 * với mỗi khoảng cách kiểm tra, mình sẽ dùng tham lam, nếu thỏa thì tăng,
 * không thỏa sẽ giảm lại trong 1 nửa của khoảng có sẵn là được
 * */

int N, C;
int T;
long long X[100000];

bool Try_d(int cur_d)
{
    int C_left = C;
    int last_cow_pos = 0;
    C_left--;
    for (int i = 1; i < N; i++)
    {
        if (X[i] - X[last_cow_pos] >= cur_d)
        {
            C_left--;
            last_cow_pos = i;
            if (C_left == 0)
            {
                break;
            }
        }
    }
    if (C_left > 0)
    {
        return false;
    }
    return true;
}

void input()
{
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        cin >> N >> C;
        for (int j = 0; j < N; j++)
        {
            scanf("%lld", &X[j]);
        }
        sort(X, X + N);
        int best_d;
        int top_d = INT32_MAX;
        int bot_d = 0;
        while (bot_d <= top_d)
        {
            int cur_d = (top_d + bot_d) / 2;
            if (Try_d(cur_d))
            {
                best_d = cur_d;
                bot_d = cur_d + 1;
            }
            else
            {
                top_d = cur_d - 1;
            }
        }
        cout << best_d << endl;
    }
}

int main(int argc, char const *argv[])
{
    input();
    return 0;
}
