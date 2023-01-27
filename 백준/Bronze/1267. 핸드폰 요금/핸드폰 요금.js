const [n, input] = require("fs")
  .readFileSync(0)
  .toString()
  .trim()
  .split("\n");

const callTimeList = input.split(" ").map(Number);
let YPrice = 0;
let MPrice = 0;

callTimeList.forEach(el => {
  YPrice += (Math.floor(el / 30) + 1) * 10;
  MPrice += (Math.floor(el / 60) + 1) * 15;
});
if (YPrice === MPrice) console.log(`Y M ${YPrice}`);
if (YPrice > MPrice) console.log(`M ${MPrice}`);
if (MPrice > YPrice) console.log(`Y ${YPrice}`);
