const input = parseInt(require("fs").readFileSync(0).toString());

for (let i = 1; i <= input; i++) {
    for (let j = 1; j <= i; j++) {
        process.stdout.write("*")

    }
    console.log("")
}