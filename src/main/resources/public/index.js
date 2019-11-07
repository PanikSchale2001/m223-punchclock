const URL = 'http://localhost:8081';
let entries = [];
window.onload = function onLoad() {
    indexPersons();
}

const renderPersons = () => {
    const display = document.querySelector('#personDisplay');
    entries.forEach((entry) => {
        if (entry.street == null){
            entry.street = "N/A";
        }
        if (entry.birthdate == null){
            entry.birthdate = "N/A";
        }
        const row = document.createElement('tr');

        let html = "<td>" + entry.id + "</td>";
        html += "<td>" + entry.lastname + "</td>";
        html += "<td>" + entry.firstname + "</td>";
        html += "<td>" + entry.street + "</td>";
        html += "<td>" + entry.zip + "</td>";
        html += "<td>" + entry.birthdate + "</td>";
        html += "<td>" + entry.username + "</td>";
        html += "<input type='button' onclick='deletePerson(" + entry.id + ")' value='Löschen' />"



        row.innerHTML = html;



        display.appendChild(row);
    });
};

const indexPersons = () => {
    fetch(`${URL}/users`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderPersons();
        });
    });
    renderPersons();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

function deletePerson(id) {
    fetch(`${URL}/users/` + id, {
        method: 'DELETE'
    }).then(r = status);
};



