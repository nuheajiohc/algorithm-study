const input = require("fs").readFileSync(0).toString().trim().split("\n").map(a => +a);
let result = [];
let sum = 0;
for (a = 0; a <= 2; a++) {
    for (b = a + 1; b <= 3; b++) {
        for (c = b + 1; c <= 4; c++) {
            for (d = c + 1; d <= 5; d++) {
                for (e = d + 1; e <= 6; e++) {
                    for (f = e + 1; f <= 7; f++) {
                        for (g = f + 1; g <= 8; g++) {
                            sum = input[a] + input[b] + input[c] + input[d] + input[e] + input[f] + input[g];
                            if (sum === 100) {
                                result = [input[a], input[b], input[c], input[d], input[e], input[f], input[g]];
                                result.sort((a, b) => a - b);
                                console.log(result.join("\n"));
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }
}