function self_number(n) {
    alt_num = n + "";
    let new_num = n + +alt_num[0];
    if (alt_num[1] !== undefined) {
        new_num += +alt_num[1];
        if (alt_num[2] !== undefined) {
            new_num += +alt_num[2];
            if (alt_num[3] !== undefined) {
                new_num += +alt_num[3];
                if (alt_num[4] !== undefined) {
                    new_num += +alt_num[4];
                }
            }
        }

    }
    return new_num;
}

let number = [];
for (let i = 1; i <= 10000; i++) {
    number[i] = 0;
}

for (let i = 1; i <= 10000; i++) {
    number[self_number(i)]++;
}
for (let i = 1; i <= 10000; i++) {
    if (number[i] == 0) {
        console.log(i);
    }
}