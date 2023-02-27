function solution(dots) {
    const [[x1,y1],[x2,y2],[x3,y3],[x4,y4]]= dots;
    const a = (y2-y1)/(x2-x1) ===(y4-y3)/(x4-x3);
    const b = (y3-y1)/(x3-x1) === (y4-y2)/(x4-x2);
    const c = (y4-y1)/(x4-x1) === (y3-y2)/(x3-x2);
    if(a||b||c){
      return 1;  
    }
    return 0;
}