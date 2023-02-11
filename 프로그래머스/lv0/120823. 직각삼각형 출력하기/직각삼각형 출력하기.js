const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
let result="";
rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    for(let i=0;i<input;i+=1){
        result+="*".repeat(i+1)+"\n";
    }
    console.log(result);
});
