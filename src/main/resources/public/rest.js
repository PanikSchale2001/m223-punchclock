const URL = 'http://localhost:8081';
const REST_BASE_URL = ""
    class  Rest {
       constructor() {
                   this._token = localStorage.getItem("token");
               }

       get token() {
                   return this._token;
                }

        set token(token) {
                   this._token = token;
                    localStorage.setItem("token", token);
                }

       isLoggedIn() {
                    return this.token != null;
                }

        async signUp(username, password, firstname, lastname, street, zip, birthdate) {
            const response = await fetch("/users/sign-up", {
                method: "POST",
                mode: "no-cors",
                body: JSON.stringify({
                    username,
                    password,
                    firstname,
                    lastname,
                    street,
                    zip,
                    birthdate,
                })
            })
        }

        async signIn(username, password) {

            const user = {};
            user['username'] = username;
            user['password'] = password;


                    const response = await fetch('login', {

                        });
                    //const token = response.headers.get("Authorization");
                this.getToken(user);
                    if (this.token == null) {
                        throw new Error("No Authorization header found");
                    }
                }

        getToken(user){
            fetch(`login`, {
                method: 'POST',
                headers: {
                    "Content-Type": 'application/json'
                },
                body: JSON.stringify(user)
            }).then((result) => {
                if (result.status === 200) {
                    let token = result.headers.get("Authorization");
                    console.log(token);
                    this.token.set(token);
                }
            });
        }



        getFetchOptions(method = "GET", body = null) {
            let options = {
                method: method,
                mode: "no-cors",
                headers: {
                    "Authorization": this.token
                }
            }
            if (body != null) {
                options.headers["Content-Type"] = "application/json"
                options.body = JSON.stringify(body);
            }
            return options;
        }

    }