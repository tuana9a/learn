#include <iostream>
#include <queue>
#include <vector>

using namespace std;
struct Arc
{
    int node;
    int weight;
    Arc(int _node, int _weight)
    {
        node = _node;
        weight = _weight;
    }
};

const int N_MAX = 1e5 + 1, M_MAX = 1e6 + 1;
const int INF = INT_MAX;

int n, m;
int s, t;
int d[N_MAX];
int result = -1;
vector<Arc> A[N_MAX];

void input()
{
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= m; i++)
    {
        int u, v, w;
        scanf("%d %d %d", &u, &v, &w);
        A[u].push_back(Arc(v, w));
    }
    scanf("%d %d", &s, &t);
}
void slove()
{
    for (int v = 1; v <= n; v++)
    {
        d[v] = INF;
    }

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> p_queue;
    d[s] = 0;
    p_queue.push(make_pair(d[s], s)); //first là trọng số, second là đỉnh
    while (!p_queue.empty())
    {
        pair<int, int> p = p_queue.top();
        p_queue.pop();
        int u = p.second;
        if (u == t)
            break;
        for (int i = 0; i < A[u].size(); i++)
        {
            Arc a = A[u][i];
            int v = a.node;
            int w = a.weight;
            if (w + d[u] < d[v])
            {
                d[v] = w + d[u];
                p_queue.push(make_pair(d[v], v));
            }
        }
    }
    cout << d[t] << endl;
}

main()
{
    freopen("input.txt", "r", stdin);
    input();
    slove();
}
