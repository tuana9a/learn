#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const* argv[]) {
    int  set_a = 0, set_b = 0;
    int num_a, num_b;
    cin >> num_a;
    for (int i = 0; i < num_a; i++) {
        int value = 0;
        cin >> value;
        set_a = set_a | (1 << value);
    }
    cin >> num_b;
    for (int i = 0; i < num_b; i++) {
        int value = 0;
        cin >> value;
        set_b = set_b | (1 << value);
    }
    for (int i = 0;i < 32; i++) {
        int index = 1 << i;
        if ((index & set_b) && ((index & set_b) != (index & set_a))) {
            cout << "0" << endl;
            return 0;
        }
    }
    cout << "1" << endl;
    return 0;
}
