#include <vector>
#include <fstream>
#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
    fstream f;
    f.open("d1.txt", ios::in);
    char a;
    while (a != EOF)
    {
        a = f.get();
        cout << a;
    }
    return 0;
}
