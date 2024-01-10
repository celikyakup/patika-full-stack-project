let btnA=document.querySelector("#btn-a")
let btnS=document.querySelector("#btn-s")
let btnD=document.querySelector("#btn-d")
let btnF=document.querySelector("#btn-f")
let btnG=document.querySelector("#btn-g")
let btnH=document.querySelector("#btn-h")
let btnJ=document.querySelector("#btn-j")
let btnK=document.querySelector("#btn-k")
let btnL=document.querySelector("#btn-l")

let boomAudio=new Audio("documents/boom.wav");
let clapAudio=new Audio("documents/clap.wav");
let hihatAudio=new Audio("documents/hihat.wav");
let kickAudio=new Audio("documents/kick.wav");
let openhatAudio=new Audio("documents/openhat.wav");
let rideudio=new Audio("documents/ride.wav");
let snareAudio=new Audio("documents/snare.wav");
let tinkAudio=new Audio("documents/tink.wav");
let tomAudio=new Audio("documents/tom.wav");

btnA.addEventListener("click",()=>{
    boomAudio.play()
})
btnS.addEventListener("click",()=>{
    clapAudio.play()
})
btnD.addEventListener("click",()=>{
    hihatAudio.play()
})
btnF.addEventListener("click",()=>{
    kickAudio.play()
})
btnG.addEventListener("click",()=>{
    openhatAudio.play()
})
btnH.addEventListener("click",()=>{
    rideudio.play()
})
btnJ.addEventListener("click",()=>{
    snareAudio.play()
})
btnK.addEventListener("click",()=>{
    tinkAudio.play()
})
btnL.addEventListener("click",()=>{
    tomAudio.play()
})


window.onkeydown=function(e){
    if(e.keyCode===83){
        clapAudio.play();
    }
    else if(e.keyCode===65){
        boomAudio.play();
    }
    else if(e.keyCode===68){
        hihatAudio.play();
    }
    else if(e.keyCode===70){
        kickAudio.play();
    }
    else if(e.keyCode===71){
        openhatAudio.play();
    }
    else if(e.keyCode===72){
        rideudio.play();
    }
    else if(e.keyCode===74){
        snareAudio.play();
    }
    else if(e.keyCode===75){
        tinkAudio.play();
    }
    else if(e.keyCode===76){
        tomAudio.play();
    }
}
    