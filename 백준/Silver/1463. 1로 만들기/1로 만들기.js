const input = Number(require("fs").readFileSync(0).toString());
const MinArr = [0, 0, 1, 1];
for (let i = 4; i <= input; i++) {
    let tmp = [];
    if (i % 3 === 0) {
        tmp.push(MinArr[(i / 3)] + 1);
    }
    if (i % 2 === 0) {
        tmp.push(MinArr[(i / 2)] + 1);
    }
    tmp.push(MinArr[(i - 1)] + 1);
    MinArr.push(Math.min(...tmp));
}
if (input == 1) {
    console.log(0);
    return 0;
} else if (input == 2 || input == 3) {
    console.log(1);
    return 0;
}
console.log(MinArr.pop());