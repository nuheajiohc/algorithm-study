const input = require("fs").readFileSync(0).toString().trim().split("\n");
const PeopleNumber = [];
let routePeople = 0;
for (route of input) {
    const [out, enter] = route.split(" ").map(a => +a);
    routePeople += enter - out;
    PeopleNumber.push(routePeople);
}
console.log(Math.max(...PeopleNumber));