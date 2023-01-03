const input = Number(require("fs").readFileSync(0).toString().trim());

const StarArr = [`${" ".repeat(input-1)}${"*".repeat(1)}`];
let Starline = '';
for (let i = 1; i < input; i++) {
    Starline = `${" ".repeat(input-1-i)}${"*".repeat((2*i)+1)}`;
    StarArr.unshift(Starline);
    StarArr.push(Starline);
}
console.log(StarArr.join("\n"));