const [T,...input] = require("fs").readFileSync(0).toString().trim().split("\n");
const result = input.map(el => {
  const [a, b] = el.split(" ").map(Number);
  let num = a % 10;
  const numberSet = new Set([num]);
  for (let i = 1; i < b; i += 1) {
    num = (num * a) % 10;
    const before = numberSet.size;
    numberSet.add(num);
    const after = numberSet.size;
    if (before === after) break;
  }

  const numberList = [...numberSet];
  const answer = numberList[(b + numberList.length - 1) % numberList.length];
  if (answer === 0) {
    return 10;
  }
  return answer;
});
console.log(result.join("\n"));