const input = require("fs").readFileSync(0).toString().trim().split("\n");
const cardList = Array.from({ length: 20 }, (_, i) => i + 1);

input.forEach(el => {
  const [a, b] = el.split(" ").map(Number);
  cardList.splice(a - 1, b - a + 1, ...cardList.slice(a - 1, b).reverse());
});
console.log(cardList.join(" "));
