const input = Number(require("fs").readFileSync(0).toString());

let line=0;
let th=input;
let n=0;
while(n<input){
    th-=line;
    line++;
    n+=line;
}
if(line%2==0){
    console.log(`${th}/${line+1-th}`);
}else{
    console.log(`${line+1-th}/${th}`);
}