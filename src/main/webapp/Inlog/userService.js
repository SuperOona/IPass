export default class UserService {
    static logIn(user, password) {
        return fetch("oonaIsCool/login", {
            method: "POST",
            body: new URLSearchParams({name: user, password: password})
        }).then(r => r.json()).then(u => {
            sessionStorage.setItem("user", JSON.stringify(u));
            return u;
        })
    }

    static logout() {
        sessionStorage.removeItem("user");
        return Promise.resolve(); //Puur om oude code te laten werken die een promise verwacht
    }

    static getUser() {
        if (sessionStorage.getItem("user") == null) {
            return Promise.resolve(null); //Puur om oude code te laten werken die een promise verwacht
        }

        return fetch("login", {
            headers: UserService.setAuthHeader({})
        }).then(r => r.json())
            .then(j => {
                return j;
            }).catch(() => {
                return null;
            })
    }

    static requireUser() {
        return this.getUser()
            .then(r => r != null)
            .then(hasUser => {
                if (!hasUser) {
                    window.location = "/login.html";
                }
            })
    }

    static setAuthHeader(headers) {
        if (sessionStorage.getItem("user") != null) {
            let user = JSON.parse(sessionStorage.getItem("user"));

            headers["Authorization"] = "Bearer " + user.token;
        }

        return headers;
    }
}
