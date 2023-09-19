#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

#define NMAX 102
#define int long long

struct Fibword
{
    int cnt;
    string left, right;
} F[NMAX];

int n;
string p;

void solve(int ncase)
{
    F[0].left = F[0].right = "0";
    F[0].cnt = (p == "0");
    F[1].left = F[1].right = "1";
    F[1].cnt = (p == "1");
    //
    for (int i = 2; i <= n; i++)
    {
        string mid = F[i - 1].right + F[i - 2].left;
        F[i].cnt = F[i - 1].cnt + F[i - 2].cnt + (mid.find(p) != string::npos); //dem p trong Fi

        if (F[i - 1].left.length() == p.length() - 1)
            F[i].left = F[i - 1].left; // tim tien to cua Fi
        else
        {
            string tmp = F[i - 1].left + F[i - 2].left;
            if (tmp.length() > p.length() - 1)
                tmp = tmp.substr(0, p.length() - 1); // chi lay dung leng(p) -1 ki tu
            F[i].left = tmp;
        }

        if (F[i - 2].right.length() == p.length() - 1)
            F[i].right = F[i - 2].right; // tim hau to cua Fi
        else
        {
            string tmp = F[i - 1].right + F[i - 2].right;
            if (tmp.length() > p.length() - 1)
                tmp = tmp.substr(tmp.length() - p.length() + 1, p.length() - 1); //chi lay dung leng(p) -1 ki tu
            F[i].right = tmp;
        }
    }
    cout << "Case " << ncase << ": " << F[n].cnt << '\n';
}

main()
{
    freopen("input.txt", "r", stdin);
    int ncase = 0;
    while (cin >> n)
    {
        cin >> p;
        solve(++ncase);
    }
}
