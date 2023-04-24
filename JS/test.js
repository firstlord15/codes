function multiplyNumeric(menu){
    for (let key in menu){
        if (key != 'title'){
            menu[key] = menu[key] * 2
        }
    }
}

let menu={
    width:200,
    height:300,
    title:"Me meny"
};

multiplyNumeric(menu);

console.log(menu)