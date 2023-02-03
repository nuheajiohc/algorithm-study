const input = require("fs").readFileSync(0).toString().trim().split("\n");
let result = "";
for (let i = 0; i < input.length - 3; i += 3) {
  const [command, n, arr] = input.slice(i + 1, i + 4);
  const parsingArr = JSON.parse(arr);
  let head = 0;
  let tail = parsingArr.length;
  let cnt = 0;
  for (let j = 0; j < command.length; j += 1) {
    if (command[j] === "R") {
      if (head < tail) {
        [head, tail] = [tail - 1, head - 1];
      } else if (tail < head) {
        [head, tail] = [tail + 1, head + 1];
      }
    } else if (command[j] === "D") {
      if (head < tail) {
        head += 1;
      } else if (tail < head) {
        head -= 1;
      } else {
        break;
      }
    }
    cnt += 1;
  }
  // console.log(head, tail);
  if (head === tail) {
    if (cnt < command.length) {
      result += "error\n";
    } else {
      result += "[]\n";
    }
  } else if (tail > head) {
    result += JSON.stringify(parsingArr.slice(head, tail)) + "\n";
  } else {
    result += JSON.stringify(parsingArr.slice(tail + 1, head + 1).reverse()) + "\n";
  }
}
console.log(result);
