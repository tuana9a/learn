#include <bits/stdc++.h>
using namespace std;

#define int long long

main()
{
    do
    {
        int n;
        cin >> n;
        if (n == 0)
            break; //EXPLAIN: đọc đến khi n = 0 thì dừng

        int arr[n];
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }

        int left_storage[n];
        left_storage[0] = 0; //EXPLAIN: thằng đầu tiên duyệt từ bên trái thì left_storage chính là nó
        stack<int> left_stack;
        left_stack.push(0);
        for (int i = 1; i < n; i++)
        {
            int top_stack_value;
            int top_stack_index;
            while (!left_stack.empty() && (top_stack_value = arr[top_stack_index = left_stack.top()]) >= arr[i])
            {
                left_stack.pop();
            }
            //CAUTION: chặn để nếu bị pop hết thì thằng thêm mới vào vẫn có thể có giá trị mà chơi
            left_storage[i] = left_stack.empty() ? 0 : (top_stack_index + 1);
            left_stack.push(i);
        }

        int right_storage[n];
        right_storage[n - 1] = n - 1;
        stack<int> right_stack;
        right_stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--)
        {
            int top_stack_value;
            int top_stack_index;
            while (!right_stack.empty() && (top_stack_value = arr[top_stack_index = right_stack.top()]) >= arr[i])
            {
                right_stack.pop();
            }
            //CAUTION: chặn để nếu bị pop hết thì thằng thêm mới vào vẫn có thể có giá trị mà chơi
            right_storage[i] = right_stack.empty() ? (n - 1) : (top_stack_index - 1);
            right_stack.push(i);
        }

        int result = 0;
        for (int i = 0; i < n; i++)
        {
            int current = arr[i] * (right_storage[i] - left_storage[i] + 1);
            result = max(result, current);
        }
        cout << result << endl;

    } while (true);
}
