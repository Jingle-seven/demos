/**
 * Created by admin on 2018/4/12.
 */

function say(name) {
 alert('Hello ' + name);
 return name;
}
//es5
var words1 = function (name) {
    return 'the name is '+ name;
};
//es6箭头表达式和反引号字符串拼接语法
let words2 = (name='远哭5') => {
    return `The game is ${name}`;
};
console.log(words2());//远哭5
console.log(words2('战神4'));//战神4
//更有甚者,如果参数只有一个,可省略括号
//如果方法体只有一句返回语句,可以省略return
let words3 = name=> `The name is ${name}`;

function test1() {
    //对象
    const people = {
        name: 'Tom',
        age: 20
    };
    let { name, age } = people;//解构
    console.log(`${name} --- ${age}`);
    const detailPeople = {...people,home:'蒙大拿'};//解压
    console.log(detailPeople);
}

function test2() {
//数组
    const color = ['red', 'blue'];
    let [first, second] = color;
    console.log(first);
    console.log(second);
    const moreColor = [...color, 'yellow'];
    console.log(moreColor);
}
// document.write(words3(say('战神4')));
export {say,words1};
export function f() {alert('Hello f');};
