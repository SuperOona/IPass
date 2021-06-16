/*
function newStatus(){
    var ja = document.forms["status"]["ja"].value;
    var nee = document.forms["status"]["nee"].value;
    var reden = document.forms["status"]["reden"].value;
    if (ja === true && nee === false && reden !== "") {
        var f = "oudStatus.json";
        writeTextFile(f, ja)
        writeTextFile(f, reden)
        return true;
    }if (ja === true && nee === true && reden !== "") {
        alert("Het kan niet ja en nee zijn. Kies er een!")
        return false;
    }else {
        alert("Het formulier is incompleet")
        return false;
    }
}

function writeTextFile(afilename, output) {
    var txtFile =new File(afilename);
    txtFile.writeln(output+"\n");
    txtFile.close();
}*/

document.getElementById("submit").onclick = function (){

}