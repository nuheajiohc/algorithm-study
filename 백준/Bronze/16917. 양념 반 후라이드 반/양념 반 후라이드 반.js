const [seasonedPrice, friedPrice, halfPrice, seasonedNumber, friedNumber] = require("fs")
  .readFileSync(0)
  .toString()
  .split(" ")
  .map(Number);
let price;
const halfNumber = Math.min(seasonedNumber, friedNumber);
const restNumber = Math.max(seasonedNumber, friedNumber) - halfNumber;

if (seasonedPrice + friedPrice > 2 * halfPrice) {
  price =
    halfPrice * halfNumber * 2 +
    seasonedPrice * (seasonedNumber - halfNumber) +
    friedPrice * (friedNumber - halfNumber);
} else if (seasonedPrice + friedPrice < 2 * halfPrice) {
  price = seasonedPrice * seasonedNumber + friedPrice * friedNumber;
}
const onlyHalf = halfPrice * 2 * (halfNumber + restNumber);
if (onlyHalf > price) {
  console.log(price);
} else {
  console.log(onlyHalf);
}
