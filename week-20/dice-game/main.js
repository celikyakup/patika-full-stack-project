const dice= [
    {
        id:1,
        title:"dice side 1",
        img:"images/dice1.png"
    },
    {
        id:2,
        title:"dice side 2",
        img:"images/dice2.png"
    },
    {
        id:3,
        title:"dice side 3",
        img:"images/dice3.png"
    },
    {
        id:4,
        title:"dice side 4",
        img:"images/dice4.png"
    },
    {
        id:5,
        title:"dice side 5",
        img:"images/dice5.png"
    },
    {
        id:6,
        title:"dice side 6",
        img:"images/dice6.png"
    }
]
let userName=localStorage.getItem("user-name") ? JSON.parse(localStorage.getItem("user-name")) : "Player 1" ;
const btn=document.querySelector(".btn");
const textInput=document.querySelector("input.u-name")

textInput.value=userName;

textInput.addEventListener("keydown",(e)=>{
    if(e.keyCode===13){
        textInput.innerHTML=textInput.value;
        localStorage.setItem("user-name",JSON.stringify(textInput.value))
    }
})

btn.addEventListener("click",function(){
    displayDice();

    setTimeout(function(){
        const imgPlayer1=document.querySelector(".py-1")
        const imgPlayer2=document.querySelector(".py-2")
        const headDiv=document.querySelector(".header")

        let randomNum1=Math.floor(Math.random()*dice.length);
        imgPlayer1.src=dice[randomNum1].img

        let randomNum2=Math.floor(Math.random()*dice.length);
        imgPlayer2.src=dice[randomNum2].img

        console.log(randomNum1,randomNum2)

        if(dice[randomNum1].id>dice[randomNum2].id){
            headDiv.innerHTML="Won!"
            
        }
        else if(dice[randomNum1].id===dice[randomNum2].id){
            headDiv.innerHTML="Draw!"
            
        }
        else{
            headDiv.innerHTML="Lose!"
            
        }
    },1200)
})

 function displayDice(){
     for (let i=0;i<dice.length;i++){
         setTimeout(function(index){
             return function(){
                const imgPlayer1=document.querySelector(".py-1")
                const imgPlayer2=document.querySelector(".py-2")
                imgPlayer1.src=dice[index].img
                imgPlayer2.src=dice[index].img
             };
        }(i),i*100)
     }
 }

 


