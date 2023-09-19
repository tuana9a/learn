#include <iostream>
#include <queue>
#include <vector>

using namespace std;
typedef pair<int, int> Element;

main()
{
    priority_queue<Element, vector<Element>, greater<Element>> pq;
    pq.push(Element(1, 1));
    pq.push(Element(2, 2));
    pq.push(Element(4, 3));
    pq.push(Element(1, 4));
    while (!pq.empty())
    {
        Element top = pq.top();
        pq.pop();
        cout << top.first << "-" << top.second << " ";
    }
}
