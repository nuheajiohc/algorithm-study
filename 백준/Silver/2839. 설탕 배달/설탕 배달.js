const input = Number(require("fs").readFileSync(0).toString());

let x=0;
let cnt=0;
let min=5000;
while(x<=input){
    if(((input-x)%3)===0){
        if(min>((x/5)+((input-x)/3))){
            min=((x/5)+((input-x)/3));
        }
    }
    else{
        cnt++;
    }
    x+=5;
}
console.log((cnt===(Math.floor(input/5)+1))?-1:min);