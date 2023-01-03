const input = require("fs").readFileSync("/dev/stdin").toString().split(" ");

const first_dice = parseInt(input[0]);
const second_dice = parseInt(input[1]);
const third_dice = parseInt(input[2]);

if (first_dice === second_dice && second_dice === third_dice) {
    console.log(10000 + first_dice * 1000);
} else if (first_dice === second_dice && first_dice !== third_dice) {
    console.log(1000 + first_dice * 100);
} else if (first_dice === third_dice && first_dice !== second_dice) {
    console.log(1000 + first_dice * 100);
} else if (second_dice === third_dice && first_dice !== second_dice) {
    console.log(1000 + second_dice * 100);
} else {
    console.log((first_dice > second_dice ? first_dice > third_dice ? first_dice : third_dice : second_dice>third_dice?second_dice:third_dice) * 100);
}