#include <iostream>
#include <cstdio>
#include <algorithm>

#define N_MAX 102
#define int long long

using namespace std;

struct Fibwords
{
    int p_count;
    string left, right;
} F[N_MAX];

void slove(int which_case, int n, string p)
{
    const size_t p_length = p.length();

    F[0].left = F[0].right = "0";
    F[0].p_count = (p == "0");

    F[1].left = F[1].right = "1";
    F[1].p_count = (p == "1");

    for (int i = 2; i <= n; i++)
    {
        string mid = F[i - 1].right + F[i - 2].left;
        F[i].p_count = F[i - 1].p_count + F[i - 2].p_count + (mid.find(p) != string::npos);

        /** 
         * vì left còn không đủ chứng tỏ phải cần cộng
         * toàn bộ F[i-1] với left của F[i-2]
         * chú ý do mình không lưu content của F[i_bất_kì]
         * thay vào đó là left và right, nên hiểu ở đây left
         * có thể chính là toàn bộ content của F[i-1]
         * */

        if (F[i - 1].left.length() == p_length - 1)
        {
            F[i].left = F[i - 1].left;
        }
        else
        {
            //EXPLAIN: previos is not enought for next one
            string temp = F[i - 1].left + F[i - 2].left;
            if (temp.length() > p_length - 1)
            {
                temp = temp.substr(0, p_length - 1);
            }
            F[i].left = temp;
        }

        if (F[i - 2].right.length() == p_length - 1)
        {
            F[i].right = F[i - 2].right;
        }
        else
        {
            string temp = F[i - 1].right + F[i - 2].right;
            if (temp.length() > p_length - 1)
            {
                temp = temp.substr(temp.length() - p_length + 1, p_length - 1);
            }
            F[i].right = temp;
        }
    }
    cout << "Case " << which_case << ": " << F[n].p_count << endl;
}

main()
{
    freopen("input.txt", "r", stdin);
    int n;
    int which_case = 1;
    while (cin >> n)
    {
        string p;
        cin >> p;
        slove(which_case, n, p);
        which_case++;
    }
}
