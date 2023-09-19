#include <iostream>
#include <algorithm>
#include <vector>

#define int long long

using namespace std;

const int N_MAX = 1e6;
int n;

int arr[N_MAX];

int answer = -1e6;

vector<vector<int>> value_index;

bool cmp(vector<int> v1, vector<int> v2)
{
    // return v1[1] > v2[1];
    return v1[2] < v2[2];
}

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < n; i++)
    {
        vector<int> temp;
        temp.push_back(i);
        temp.push_back(arr[i]);
        temp.push_back(abs(arr[i]));
        value_index.push_back(temp);
    }
    sort(value_index.begin(), value_index.end(), cmp);
}

void printReach()
{
    cout << "reach" << endl;
}

main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    freopen("input.txt", "r", stdin);
    input();

    int min_idx;
    for (int i = 0; i < n; i++)
    {
        vector<int> value_index_e = value_index[i];
        int idx = value_index_e[0];
        int value = value_index_e[1];
        int abs_value = value_index_e[2];
    }
}