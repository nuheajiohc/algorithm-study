const attendanceList = require("fs")
  .readFileSync("dev/stdin")
  .toString()
  .split("\n")
  .map(Number);

const attendanceSet = new Set(attendanceList);

for (let i = 1; i <= 30; i += 1) {
  if (!attendanceSet.has(i)) {
    console.log(i);
  }
}
