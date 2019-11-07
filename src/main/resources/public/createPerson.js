const URL = 'http://localhost:8081/createPerson.html';
const REST_BASE_URL = "";
    class CreatePerson {
       getToken(username, password, firstname, lastname, street, zip) {
            fetch(`/users/sign-up`, {
                method: 'POST',
                headers: {
                    "Content-Type": 'application/json'
                },
                body: JSON.stringify({
                    username,
                    password,
                    firstname,
                    lastname,
                    street,
                    zip

                })
            }).then((result) => {
                if (result.status === 200) {
                }
            });
        }
    }
