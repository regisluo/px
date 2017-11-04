var fs = require("fs");
var msg = require("./message");
var util = require("./util");
var dataFile = "./data/tutors.json";
var contentType = "application/json";

exports.getTutors = function (request, response) {
    fs.readFile(dataFile, function (error, content) {
        if (error) {
            msg.show500(request, response, error);
        } else {
            msg.sendJson(request, response, content);
        }
    });

};

exports.getTutor = function (request, response, id) {
    try {
        fs.readFile(dataFile, function (error, content) {
            if (error) {
                throw new Error("Internal Error");
            } else {
                var Tutors = JSON.parse(content);
                if (Tutors) {
                    for (var i = 0; i < Tutors.length; i++) {
                        console.log("processing Tutor: " + Tutors[i]["id"]);
                        if (id == Tutors[i]["id"]) {
                            console.log("find a Tutor with id: " + id);
                            msg.sendJson(request, response, JSON.stringify(Tutors[i]));
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

exports.addTutor = function (request, response, requestBody) {
    try {
        var data = JSON.parse(requestBody);
        if (data) {
            var Tutors = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    Tutors = [];
                    if (content.length > 0) {
                        Tutors = JSON.parse(content);
                    }
                    var nextId = util.getNextId(Tutors, "id");
                    console.log("next id: " + nextId);
                    data.id = nextId;
                    Tutors.push(data);
                    console.log("current size: " + Tutors.length);
                    fs.writeFile(dataFile, JSON.stringify(Tutors), function (err) {
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

exports.updateTutor = function (request, response, requestBody) {
    try {
        var data = JSON.parse(requestBody);
        if (data) {
            var Tutors = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    Tutors = [];
                    if (content.length > 0) {
                        Tutors = JSON.parse(content);
                    }

                    util.updateObject(Tutors, data, "id");
                    console.log("after update: \n" + Tutors);
                    fs.writeFile(dataFile, JSON.stringify(Tutors), function (err) {
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

exports.deleteTutor = function (request, response, data) {
    try {
        if (data) {
            var Tutors = null;
            fs.readFile(dataFile, function (error, content) {
                if (error) {
                    msg.show500(request, response, error);
                } else {
                    Tutors = [];
                    if (content.length > 0) {
                        Tutors = JSON.parse(content);
                    }

                    util.deleteObject(Tutors, data, "id");
                    console.log("after delete: \n" + Tutors);
                    var json = "";
                    if (Tutors.length > 0) {
                        json = JSON.stringify(Tutors);
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

