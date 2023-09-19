#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#define NMAX 100001

using namespace std;

vector<int> A[NMAX];
int N, M;
int d[NMAX]; //EXPLAIN: d[i] level of i

void input()
{
    // cin >> N >> M;
    scanf("%d %d", &N, &M);
    for (int i = 1; i <= M; i++)
    {
        int u, v;
        // cin >> u >> v;
        scanf("%d %d", &u, &v);
        A[u].push_back(v);
        A[v].push_back(u);
    }
}

void init()
{
    //EXPLAIN: reset visited
    for (int i = 1; i <= N; i++)
    {
        d[i] = -1;
    }
}

bool bfs(int start)
{
    queue<int> Q;
    Q.push(start);
    d[start] = 0;
    while (!Q.empty())
    {
        int v = Q.front();
        Q.pop();
        //EXPLAIN: duyệt qua tất cả đỉnh kề
        for (int i = 0; i < A[v].size(); i++)
        {
            int x = A[v][i];
            if (d[x] == -1)
            {
                d[x] = d[v] + 1;
                Q.push(x);
            }
            else
            {
                if ((d[v] + d[x]) % 2 == 0)
                {
                    return false;
                }
            }
        }
    }
    return true;
}

void slove()
{
    int ans = 1;
    for (int i = 1; i <= N; i++)
    {
        init();
        if (!bfs(i))
        {
            ans = 0;
            break;
        }
    }
    cout << ans << endl;
}

main()
{
    
    // freopen("input.txt", "r", stdin);
    input();
    slove();
}
