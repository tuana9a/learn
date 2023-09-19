#include <iostream>
#include <stack>
using namespace std;

bool isOpenParentheses(char c)
{
    if (c == '(')
    {
        return true;
    }
    return false;
}

bool checkSolution(string str)
{
    stack<char> stk;
    char x;

    for (int i = 0; i < str.length(); i++)
    {
        if (str[i] == '(')
        {
            stk.push(str[i]);
            continue;
        }
        if (stk.empty())
            return false;

        x = stk.top();
        stk.pop();
    }
    
    return (stk.empty());
}

int main(int argc, char const *argv[])
{

    return 0;
}
