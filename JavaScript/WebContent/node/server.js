var http = require('http');
var fs = require('fs');
var path = require('path');
var url = require('url');
var settings = require('./settings');
var student = require('../controller/student');
var msg = require("./message");

http.createServer(function (request, response) {
	var filePath = request.url;
	console.log('filePath: ' + filePath);

	switch (request.method) {
		case "GET":
			var idPattern = "[0-9]+";
			var ptn = new RegExp("/students/" + idPattern);
			if (filePath === "/students") {
				student.getStudents(request, response);
			} else if (ptn.test(filePath)) {
				ptn = new RegExp(idPattern);
				var id = ptn.exec(filePath);
				console.log("Finding a student with id: " + id);
				student.getStudent(request, response, id);
			}
			else {
				staticResponse(request, response, filePath);
			}
			break;
		case "POST":
			if (filePath === "/students") {
				var reqBody = '';
				request.on("data", function (data) {
					reqBody += data;
				});
				console.log(reqBody);
				request.on("end", function () {
					student.addStudent(request, response, reqBody);
				});
			} else {
				msg.show404(request, response, "Internal Error");
			}
			break;
		case "PUT":
			if (filePath === "/students") {
				var reqBody = '';
				request.on("data", function (data) {
					reqBody += data;
				});
				request.on("end", function () {
					student.updateStudent(request, response, reqBody);
				});
			} else {
				msg.show404(request, response, "Internal Error");
			}
			break;
		case "DELETE":
			if (filePath === "/students") {
				var reqBody = '';
				request.on("data", function (data) {
					reqBody += data;
				});
				request.on("end", function () {
					student.deleteStudent(request, response, reqBody);
				});
			} else {
				msg.show404(request, response, "Internal Error");
			}
			break;
		default:
			break;
	}




}).listen(settings.port, function () {
	console.log('Server running at localhost:' + settings.port);
});

function staticResponse(request, response, filePath) {
	if (filePath === '/') {
		filePath = '../index.html';
	} else {
		filePath = '../' + filePath;
	}

	var extname = path.extname(filePath);
	var contentType;

	switch (extname) {
		case '.html':
			contentType = 'text/html';
			break;
		case '.js':
			contentType = 'text/javascript';
			break;
		case '.css':
			contentType = 'text/css';
			break;
		default: contentType = 'text/plain';
	}

	fs.readFile(filePath, function (error, content) {
		if (error) {
			msg.show404(request, response, error);
		} else {
			msg.show200(request, response, content, contentType);
		}
	});
}