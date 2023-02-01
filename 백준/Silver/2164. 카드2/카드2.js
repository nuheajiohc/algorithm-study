const N = Number(require("fs").readFileSync(0).toString());
const NList = Array.from({ length: N }, (_, i) => i + 1);
let head = 0;
let tail = NList.length - 1;
if (NList.length === 1) {
  return console.log(1);
}
while (1) {
  head += 1;
  if (head === tail) {
    break;
  }
  NList[++tail] = NList[head++];
}
console.log(NList[tail]);
