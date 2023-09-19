
BCA:
ý tưởng x[i] = v với i là môn, v là giáo viên
x[i] = v tức môn i được dạy bởi giáo viên v

các candidate check bằng G[i] mảng các giáo viên có thể dạy môn i, biến thêm mới
load[v]++ giáo viên v sẽ được tăng nặng công việc

if (đã gán hết cho các môn thì solution()) {
    check min của load, cập nhật load
}

============================================================
CBUS:
n khách 
khách 1 -> n+1
khách 2 -> n+2

x[2n+1] quãng đg đi của xe bus

ràng buộc điểm đón trước điểm trả
số khách trên xe <= k

visisted[]
load // current load of the bus

check() {
    check visisted, return false
    if (v <= n) {
        if(visisted[n+v]) return false
        if (load >= k) return false
    } else {
        if(!visisted[v-n]) return false
    }
}

Try(i) {
    for(i in range 2n)
    {
        
    }
}


