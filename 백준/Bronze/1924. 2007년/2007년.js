const [M, D] = require("fs").readFileSync(0).toString().trim().split(" ").map(a => +a);
const days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
let DaySum = D;
for (let i = 0; i < M; i++) {
    DaySum += days[i];
}
const week = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];

console.log(week[DaySum % 7]);