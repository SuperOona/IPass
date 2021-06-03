function inlog(){
    var gebruikersnaam = document.forms["inloggen"]["gebruikersnaam"].value;
    var wachtwoord= document.forms["inloggen"]["wachtwoord"].value;

    document.getElementById("login").onclick = function () {
        location.href = "/IPass/src/main/Status/status.html?_ijt=khd9j5ngl40kfn40539ihm5584";
    };
}

function readTextFile(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                var allText = rawFile.responseText;
                alert(allText);
            }
        }
    }
    rawFile.send(null);
}


