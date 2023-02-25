function solution(spell, dic) {
    const spellStr =spell.sort().join("");
    const dicSort = dic.map(el=>el.split("").sort().join(""));
    const dicSet = new Set(dicSort);
    const answer =  dicSet.has(spellStr)?1:2;
    return answer;
}
