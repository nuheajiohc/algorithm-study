const input = require("fs").readFileSync(0).toString();
let result = 0;
let num = 0;
let cnt = 99;

function hansu(input) {
    for (let i = 1; i <= Number(input); i++) {
        if (Number(input) < 100) {
            cnt = Number(input);
            break;
        } else {
            if ((i.toString()[0] - i.toString()[1]) === (i.toString()[1] - i.toString()[2])) {
                cnt++;
            }
        }
    }
    console.log(cnt);
}
hansu(input);