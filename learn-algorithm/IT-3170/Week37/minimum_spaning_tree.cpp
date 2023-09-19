#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
struct Edge
{
    int u, v;
    int weight;
    Edge(int _u, int _v, int _weight)
    {
        u = _u;
        v = _v;
        weight = _weight;
    }
};
vector<Edge> edges;
vector<Edge> result_edges;
int result_min = 0;

const int N_MAX = 1e5 + 1, M_MAX = 1e5 + 1;
int p[N_MAX]; //p[x] cha của nút x
int r[N_MAX]; //r[x] hạng của nút x
int n, m;

void print_reach()
{
    cout << "reach" << endl;
}

void makeSet(int x)
{
    p[x] = x;
    r[x] = 0;
}

int find(int x)
{
    if (x != p[x])
    {
        p[x] = find(p[x]); //gọi tìm của nút cha và cập nhật của bản thân
    }
    return p[x]; //kết quả ở đây sẽ là nút gốc :))
}
/**
 * @param x root của một tập set
 * @param y root của một cập set khác 
 */
void unify(int x, int y)
{
    if (r[x] > r[y])
    {
        //r[x] càng cao tức càng sâu
        //nếu độ cao của x > của y thì y làm con của x
        //vì x càng sâu thì nó cách root xa, còn y sẽ gần root của nó
        //vậy nếu nối root_y cho root_x thì độ sâu sẽ bé hơn chiều ngược lại
        p[y] = x;
    }
    else
    {
        //ngược lại x làm con của y
        p[x] = y;
        if (r[x] == r[y]) //nhưng có thể 2 thằng này bằng nhau thì
        {
            r[y] = r[y] + 1;
            //tăng độ sâu
        }
    }
}

void input()
{
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= m; i++)
    {
        int u, v, w;
        scanf("%d %d %d", &u, &v, &w);
        edges.push_back(Edge(u, v, w));
    }
}

bool edge_compare(Edge e1, Edge e2)
{
    return e1.weight < e2.weight;
}

void slove()
{
    sort(edges.begin(), edges.end(), edge_compare);
    for (int i = 1; i <= n; i++)
    {
        makeSet(i);
    }
    for (int i = 0; i < m; i++)
    {
        int root_u = find(edges[i].u);
        int root_v = find(edges[i].v);
        if (root_u != root_v)
        {
            unify(root_u, root_v);
            result_edges.push_back(edges[i]);
            result_min += edges[i].weight;
            if (result_edges.size() == n - 1)
            {
                break;
            }
        }
    }
}

main()
{
    // freopen("input.txt", "r", stdin);
    input();
    slove();
    cout << result_min << endl;
}