#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const* argv[]) {
    int n;
    cin >> n;

    //EXPLAIN: mảnh input
    long arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    //EXPLAIN: tính tổng trước từ 0 -> n lưu vào mảng prepared_total
    long prepared_total[n];
    prepared_total[0] = arr[0];
    for (int i = 1; i < n;i++) {
        prepared_total[i] = prepared_total[i - 1] + arr[i];
    }

    //EXPLAIN: chuẩn bị các tham số cho việc tính max subseqence
    long sub_min_current = 0;   //biến này cho việc min từ đầu tới i
    long result = prepared_total[0];

    //EXPLAIN: cụ thể hơn có thể xem hình giải thích
    for (int i = 0; i < n;i++) {
        result = max(result, prepared_total[i] - sub_min_current);
        sub_min_current = min(sub_min_current, prepared_total[i]);
    }

    cout << result;
}
