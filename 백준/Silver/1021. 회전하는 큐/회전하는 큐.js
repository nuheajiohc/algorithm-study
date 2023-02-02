const input = require("fs").readFileSync(0).toString().trim().split("\n");
const [N, M] = input[0].split(" ");
const NList = Array.from({ length: N }, (_, i) => i + 1);
const order = input[1].split(" ").map(Number);
let result = 0;
order.forEach(el => {
  let count = 0;
  while (1) {
    if (NList[count] === el) {
      if (count < NList.length / 2) {
        for (let i = 1; i < count + 1; i += 1) {
          NList.push(NList.shift());
          result += 1;
        }
        NList.shift();
      } else {
        for (let i = 1; i <= NList.length - count; i += 1) {
          NList.unshift(NList.pop());
          result += 1;
        }
        NList.shift();
      }
      break;
    }
    count += 1;
  }
});
console.log(result);
