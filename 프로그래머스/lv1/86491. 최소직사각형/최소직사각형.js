function solution(sizes) {
    const walletSize=[...sizes[0]].sort((a,b)=>a-b);
    sizes.forEach(el=>{
        walletSize[0]=Math.max(Math.min(...el),walletSize[0]);
        walletSize[1]=Math.max(Math.max(...el),walletSize[1]);
    })
    const answer = walletSize[0]*walletSize[1];
    return answer;
}