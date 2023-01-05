const input = require("fs").readFileSync(0).toString().split("\n");

const guests = Number(input[0]);
for(let i=1; i<=guests; i++){
    let roomnumber = '';
    const guest = input[i].split(" ")
    const h = Number(guest[0]);
    const w = Number(guest[1]);
    const n = Number(guest[2]);
    let st = Math.ceil(n/h);
    let floor = n%h;
    if(floor==0){
        floor=h;
    }
    roomnumber+=floor;
    if(st<10){
        st='0'+ st;
    }
    roomnumber+=st;
    console.log(roomnumber);
}