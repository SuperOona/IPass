import UserService from "userService.js";

document.querySelector("form button.primary-button").addEventListener("click", e => {
    console.log("ontvangen")
    e.preventDefault();
    UserService.logIn(document.forms["login"].gebruikersnaam.value, document.forms["login"].wachtwoord.value)
        .then(u => {
            if (u != null) {
                location.href = "Status/status.html";
            }
        });
});
