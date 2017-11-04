var fs = require("fs");
var msg = require("../node/message");
var util = require("../node/util");
var dataFile = "../data/students.json";
var contentType = "application/json";

exports.getStudents = function (request, response) {
    fs.readFile(dataFile, function (error, content) {
        if (error) {
            msg.show500(request, response, error);
        } else {
            msg.sendJson(request, response, content);
        }
    });

};

exports.getStudent = function (request, response, id) {
    try {
        fs.readFile(dataFile, function (error, content) {
            if (error) {
                throw new Error("Internal Error");
            } else {
                var students = JSON.parse(content);
                if (students) {
                    for (var i = 0; i < students.length; i++) {
                        console.log("processing student: " + students[i]["id"]);
                        if (id == students[i]["id"]) {
                            console.log("find a student with id: " + id);
                            msg.sendJson(request, response, JSON.stringify(students[i]));
                            break;
                        }
                    }
                    msg.sendJson(request, response, JSON.stringify({ "status": "error", "desc": "cannot find object with id " + id }));
                } else {
                    throw new Error("Internal Error");
                }

            }
        });
    } catch (error) {
        msg.show500(request, response, error);
    }

};

exports.addStudent = function (request, response, requestBody) {
    try {
        var data = JSON.parse(requestBody);
        if (data) {
            var students = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    students = [];
                    if (content.length > 0) {
                        students = JSON.parse(content);
                    }
                    var nextId = util.getNextId(students, "id");
                    console.log("next id: " + nextId);
                    data.id = nextId;
                    students.push(data);
                    console.log("after add: \n" + students);
                    fs.writeFile(dataFile, JSON.stringify(students), function (err) {
                        if (err) throw err;
                    });
                }
            });
            msg.sendJson(request, response, JSON.stringify({ "status": "success" }));
        } else {
            throw new Error("Request data not valid.");
        }
    } catch (error) {
        msg.show500(request, response, error);
    }
};

exports.updateStudent = function (request, response, requestBody) {
    try {
        var data = JSON.parse(requestBody);
        if (data) {
            var students = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    students = [];
                    if (content.length > 0) {
                        students = JSON.parse(content);
                    }

                    util.updateObject(students, data, "id");
                    console.log("after update: \n" + students);
                    fs.writeFile(dataFile, JSON.stringify(students), function (err) {
                        if (err) throw err;
                    });
                }
            });
            msg.sendJson(request, response, JSON.stringify({ "status": "success" }));
        } else {
            throw new Error("Request data not valid.");
        }
    } catch (error) {
        msg.show500(request, response, error);
    }
};

exports.deleteStudent = function (request, response, requestBody) {
    try {
        var data = JSON.parse(requestBody);
        if (data) {
            var students = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    students = [];
                    if (content.length > 0) {
                        students = JSON.parse(content);
                    }

                    util.deleteObject(students, data, "id");
                    console.log("after delete: \n" + students);
                    var json = "";
                    if (students.length > 0) {
                        json = JSON.stringify(students);
                    }
                    fs.writeFile(dataFile, json, function (err) {
                        if (err) throw err;
                    });
                }
            });
            msg.sendJson(request, response, JSON.stringify({ "status": "success" }));
        } else {
            throw new Error("Request data not valid.");
        }
    } catch (error) {
        msg.show500(request, response, error);
    }
};

