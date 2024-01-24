
const file = 'jokes.json';

fetch(file)
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(jokes => {
    
    let pDOM=document.querySelector(".jokes")
    let randomIndex=Math.floor(Math.random()*jokes.length);
    pDOM.innerText=jokes[randomIndex].value;
    
    let btnDOM=document.querySelector(".btn-jokes")
    let listRandomindex=[];

    btnDOM.addEventListener("click", function randomJokes(){
        let randomIndex=Math.floor(Math.random()*jokes.length);
        listRandomindex.push(randomIndex);
        while (listRandomindex[0]===listRandomindex[1]){
            randomIndex=Math.floor(Math.random()*jokes.length);
            listRandomindex[1]=randomIndex
        }
        listRandomindex[0]=randomIndex
        listRandomindex.splice(1);
        pDOM.innerText=jokes[randomIndex].value;
          
    })    
  })
  .catch(error => {
    console.error('Error:', error);
  });