let toDoList=localStorage.getItem("to-do-list") ? JSON.parse(localStorage.getItem("to-do-list")) : [] ;

let listDom=document.querySelector("#list")
toDoList.forEach(todo=>{
    let liDom=document.createElement("li");
    liDom.innerHTML=todo; 
    listDom.appendChild(liDom);
})

let myNodelist = document.getElementsByTagName("LI");
    for (let i = 0; i < myNodelist.length; i++) {
        let span = document.createElement("SPAN");
        let txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span); 
    }


let close=document.querySelectorAll(".close")
close.forEach(event=>{
    event.onclick=function(){
        let li=this.parentElement;
        li.remove();
        toDoList.splice(li,1);
        console.log(toDoList);
        localStorage.setItem("to-do-list",JSON.stringify(toDoList))
    }
})


listDom.addEventListener("click",function(e){
    if(e.target.tagName==="LI"){
        e.target.classList.toggle("checked");
    }
})


function newElement(){
    
    let taskDom=document.querySelector("#task");
    let listDom=document.querySelector("#list");
    let liDom=document.createElement("li");
    
    if(taskDom.value.trim()===""){
        $("#liveToastError").toast("show");
        taskDom.value="";
        return;
        }

    else {
        listDom.appendChild(liDom);
        liDom.innerHTML=taskDom.value;
        toDoList.push(taskDom.value);
        $("#liveToastSuccess").toast("show");
        localStorage.setItem("to-do-list",JSON.stringify(toDoList))
        taskDom.value="";
    }

    let myNodelist = document.getElementsByTagName("LI");
    for (let i = 0; i < myNodelist.length; i++) {
        let span = document.createElement("SPAN");
        let txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span); 
    }

    let close=document.querySelectorAll(".close")
    close.forEach(event=>{
        event.onclick=function(){
            let li=this.parentElement;
            li.remove();
            toDoList.splice(li,1);
            console.log(toDoList);
            localStorage.setItem("to-do-list",JSON.stringify(toDoList))
        }
    })

}

    
