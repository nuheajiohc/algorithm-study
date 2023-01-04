const input = require("fs").readFileSync(0).toString().split("\n");
const TestCase = Number(input.shift());
for(let i=1; i<=TestCase; i++){
    const floor = +input.shift();
    const ho = +input.shift();
    const apartment = Array.from(Array(floor+1), () => Array(ho+1).fill(0));
    for (let i =1; i<=ho; i++){
        apartment[0][i]=i;
    }
    for (let i=1; i<=floor; i++){
        for (let j=1; j<=ho; j++){
            apartment[i][j]=apartment[i][j-1]+apartment[i-1][j];
        }
    }
    console.log(apartment[floor][ho]);
}

