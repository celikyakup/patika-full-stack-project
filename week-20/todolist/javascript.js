let toDoList=localStorage.getItem("to-do-list") ? JSON.parse(localStorage.getItem("to-do-list")) : new Map() ;

let listDom=document.querySelector("#list")

for(let todo in toDoList){
    let liDom=document.createElement("li");
    liDom.innerHTML=todo; 
    listDom.appendChild(liDom);
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
        //console.log(li.textContent.split("×")[0]);
        delete toDoList[li.textContent.split("×")[0]];
        localStorage.setItem("to-do-list",JSON.stringify(toDoList));
    }
})

for(let check in toDoList){
    if (toDoList.hasOwnProperty(check)){
        let status=toDoList[check].status;
        console.log(status)
        if(status){
            let listItem=$("li:contains('"+check+"')");
            if(listItem){
                listItem.addClass("checked");
            }
        }
    }
}

listDom.addEventListener("click",function(e){
    
    if(e.target.tagName==="LI" ){

        //console.log(e.target.textContent.split("×")[0])
        toDoList[e.target.textContent.split("×")[0]].status=!toDoList[e.target.textContent.split("×")[0]].status;
        localStorage.setItem("to-do-list",JSON.stringify(toDoList));
        e.target.classList.toggle("checked",toDoList[e.target.textContent.split("×")[0]].status)
        
    }
})

function newElement(){
    
    let taskDom=document.querySelector("#task");
    //let listDom=document.querySelector("#list");
    let liDom=document.createElement("li");
    
    if(taskDom.value.trim()===""){
        $("#liveToastError").toast("show");
        taskDom.value="";
        return;
        }

    else {
        listDom.appendChild(liDom);
        liDom.innerHTML=taskDom.value;
        toDoList[taskDom.value]={
            "do":taskDom.value,
            "status":false
        }
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
            //console.log(li.textContent.split("×")[0]);
            delete toDoList[li.textContent.split("×")[0]];
            localStorage.setItem("to-do-list",JSON.stringify(toDoList));
            }
    })

}

    
