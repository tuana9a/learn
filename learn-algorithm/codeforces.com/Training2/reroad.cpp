#include <bits/stdc++.h>
using namespace std;

#define int long long

main()
{
    int n;
    cin >> n;
    int arr[n];

    int num_of_road = 1;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    for (int i = 1; i < n; i++)
    {
        if (arr[i] != arr[i - 1])
        {
            num_of_road++;
        }
    }

    int q;
    cin >> q;
    for (int i = 0; i < q; i++)
    {
        int p, c;
        cin >> p >> c;
        p--; //EXPLAIN: chuyển về index bắt đầu từ 0

        if (p != 0 && arr[p] != arr[p - 1])
        {
            num_of_road--;
        }
        if (p != n - 1 && arr[p] != arr[p + 1])
        {
            num_of_road--;
        }
        arr[p] = c;
        if (p != 0 && arr[p] != arr[p - 1])
        {
            num_of_road++;
        }
        if (p != n - 1 && arr[p] != arr[p + 1])
        {
            num_of_road++;
        }
        cout << num_of_road << endl;
    }
}
