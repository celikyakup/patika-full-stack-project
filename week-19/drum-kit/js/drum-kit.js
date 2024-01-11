let body=document.querySelector("body")

let boomAudio=new Audio("documents/boom.wav");
let clapAudio=new Audio("documents/clap.wav");
let hihatAudio=new Audio("documents/hihat.wav");
let kickAudio=new Audio("documents/kick.wav");
let openhatAudio=new Audio("documents/openhat.wav");
let rideudio=new Audio("documents/ride.wav");
let snareAudio=new Audio("documents/snare.wav");
let tinkAudio=new Audio("documents/tink.wav");
let tomAudio=new Audio("documents/tom.wav");


body.addEventListener("click",(e)=>{
    
    switch(e.target.innerHTML){
        case "A":
            boomAudio.play();
            break;
        case "S":
            clapAudio.play();
            break;
        case "D":
            hihatAudio.play();
            break;
        case "F":
            kickAudio.play();
            break;
        case "G":
            openhatAudio.play();
            break;
        case "H":
            rideudio.play();
            break;
        case "J":
            snareAudio.play();
            break;
        case "K":
            tinkAudio.play();
            break;
        case "L":
            tomAudio.play();
            break;
    }
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
    