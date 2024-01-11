let userName=prompt("Lütfen İsminizi giriniz ")
let myName=document.querySelector("strong>#myName");
myName.append(`${userName[0].toUpperCase()+userName.substring(1)}`)

function addZeroLessThanTen(dateValue){
    let dateSyntax="";
    if(dateValue<10){
        dateSyntax=`0${dateValue}`;
    }
    else{
        dateSyntax=dateValue;
    }
    return dateSyntax;
}

function clock(){
    let date=new Date()
    let hours=addZeroLessThanTen(date.getHours())
    let minutes=addZeroLessThanTen(date.getMinutes())
    let second=addZeroLessThanTen(date.getUTCSeconds())
    let days=["Pazar","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi"]
    let day=days[date.getDay()]
    let activeHours=document.querySelector("#myClock")
    
    activeHours.innerHTML=(`${hours}:${minutes}:${second} ${day}`)
    
}

setInterval(clock,1000)
