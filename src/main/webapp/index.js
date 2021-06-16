let status = document.querySelector("#statusen")


fetch("/oonaIsCool/status").then(r=>r.json()).then(cs=>{
    for(let c of cs){
        status.innerHTML +="<d>"+c.reden+"</d>";
    }
});

document.getElementById("myButton").onclick = function () {
    location.href = "Inlog/inlog.html";
};