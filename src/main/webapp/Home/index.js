let status = document.querySelector("#statusen")

fetch("/restservices/allproducts").then(r=>r.json()).then(cs=> {
    for (let c of cs) {
        status.innerHTML+=c.status
    }
});

document.getElementById("myButton").onclick = function () {
    location.href = "../Inlog/inlog.html";
};