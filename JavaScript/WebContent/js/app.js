/**
 * This is used for Front End Basic Tutorial Demo
 */
var url = "http://localhost:8888/students";
var method = "GET";
var xhttp = new XMLHttpRequest();


function getStudents(students) {
    xhttp.open(method, url, true);
    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            students = JSON.parse(this.responseText);
        }
    }
}

function getStudent(id) {
    var url = url + id;
    xhttp.open(method, url, true);
    xhttp.send();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            return JSON.parse(this.responseText);
        }
    }
}

function addStudent(student) {
    var method = "POST";
    xhttp.open(method, url, true);
    xhttp.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhttp.send(JSON.stringify(student));

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            return JSON.parse(this.responseText);
        }
    }
}

function updateStudent() {
    var method = "PUT";
    xhttp.open(method, url, true);
    xhttp.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhttp.send(JSON.stringify(student));

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            return JSON.parse(this.responseText);
        }
    }
}

function deleteStudent(student) {
    var method = "DELETE";
    xhttp.open(method, url, true);
    xhttp.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhttp.send(JSON.stringify(student));

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            return JSON.parse(this.responseText);
        }
    }
}
/*
Just wrapping update-operations together
operation: flag used to indicate which operation to use
    "A": add a new student
    "U": update a student
    "D": delete a student
 */
function studentOperation(student, operation) {
    var method;
    switch (operation) {
        case 'A':
            method = "POST";
            break;
        case 'U':
            method = "UPDATE";
            break;
        case 'D':
            method = "DELETE";
            break;
    }

    if (method) {
        xhttp.open(method, url, true);
        xhttp.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhttp.send(JSON.stringify(student));

        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                return JSON.parse(this.responseText);
            }
        }
    }
}