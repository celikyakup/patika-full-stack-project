let myName=document.querySelector("strong>#myName");

let userName=prompt("Lütfen İsminizi giriniz ")

myName.append(`${userName[0].toUpperCase()+userName.substring(1)}`)

function clock(){
    let date=new Date()
    let hours=date.getHours()
    let minutes=date.getMinutes()
    let second=date.getUTCSeconds()
    let days=["Pazar","Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi"]
    let day=days[date.getDay()]
    let activeHours=document.querySelector("#myClock")
    if(hours<10){
        activeHours.innerHTML=(`0${hours}:${minutes}:${second} ${day}`)
    }
    else if(minutes<10){
        activeHours.innerHTML=(`${hours}:0${minutes}:${second} ${day}`)
    }
    else if(second<10){
        activeHours.innerHTML=(`${hours}:${minutes}:0${second} ${day}`)
    }
    else if(hours<10 && minutes<10){
        activeHours.innerHTML=(`0${hours}:0${minutes}:${second} ${day}`)
    }
    else if(minutes<10 && second<10){
        activeHours.innerHTML=(`${hours}:0${minutes}:0${second} ${day}`)
    }
    else if(hours<10 && second<10){
        activeHours.innerHTML=(`0${hours}:${minutes}:0${second} ${day}`)
    }
    else if(hours<10 && minutes<10 && second<10){
        activeHours.innerHTML=(`0${hours}:0${minutes}:0${second} ${day}`)
    }
    else{
        activeHours.innerHTML=(`${hours}:${minutes}:${second} ${day}`)
    }
}

setInterval(clock,1000)
