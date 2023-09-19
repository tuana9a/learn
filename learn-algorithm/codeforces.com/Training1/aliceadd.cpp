#include <bits/stdc++.h>
using namespace std;

string addBigNum(string num1, string num2) {
    while (num1.length() < num2.length()) num1 = "0" + num1;
    while (num2.length() < num1.length()) num2 = "0" + num2;

    string result = num1;
    int carry = 0;

    for (int i = num1.length() - 1; i >= 0; i--) {
        int total = num1[i] - '0' + num2[i] - '0' + carry;
        result[i] = (total % 10) + '0';
        carry = total / 10;
    }
    if (carry > 0) result = "1" + result;

    return result;
}

int main(int argc, char const* argv[]) {
    string a, b;
    cin >> a >> b;
    cout << addBigNum(a, b);
    return 0;
}
