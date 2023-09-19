#include <bits/stdc++.h>
using namespace std;

#define int long long

main() {
    int n, b;
    cin >> n >> b;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int max_left_storage[n];
    max_left_storage[0] = arr[0];
    for (int i = 1; i < n; i++) {
        int current_value = arr[i];
        max_left_storage[i] = max(current_value, max_left_storage[i - 1]);
    }

    int max_right_storage[n];
    max_right_storage[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        int current_value = arr[i];
        max_right_storage[i] = max(current_value, max_right_storage[i + 1]);
    }

    int result_cut = -1;
    for (int i = 1; i < n - 1; i++) {
        int current_value = arr[i];

        int max_left = max_left_storage[i - 1];
        int delta_left = max_left - current_value;

        int max_right = max_right_storage[i + 1];
        int delta_right = max_right - current_value;

        if (delta_left >= b && delta_right >= b) {
            int current_cut = delta_left + delta_right;
            result_cut = max(result_cut, current_cut);
        }
    }
    cout << result_cut;
}
