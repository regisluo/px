var http = require('http');
var fs = require('fs');
var path = require('path');
var url = require('url');
var settings = require('./node_scripts/settings');
var student = require('./node_scripts/student');
var tutor = require('./node_scripts/tutor');
var msg = require("./node_scripts/message");

http.createServer(function (request, response) {
	var filePath = request.url;
	var idPattern = "[0-9]+";
	var ptn = new RegExp("/students/" + idPattern);
	var ptnTutor = new RegExp("/tutors/" + idPattern);
	switch (request.method) {
		case "GET":


			if (filePath === "/students") {
				student.getStudents(request, response);
			} else if (filePath === "/tutors") {
				tutor.getTutors(request, response);
			} else if (filePath === "/nationalities") {
				var nationalities = [{ 'label': 'CN', 'value': 'CN' },
				{ 'label': 'UK', 'value': 'UK' },
				{ 'label': 'AU', 'value': 'AU' },
				{ 'label': 'US', 'value': 'US' },
				{ 'label': 'JP', 'value': 'JP' }
				];
				msg.sendJson(request, response, JSON.stringify(nationalities));
			}
			else if (ptn.test(filePath)) {
				var id = new RegExp(idPattern).exec(filePath);
				console.log("Finding a student with id: " + id);
				student.getStudent(request, response, id);
			} else if (ptnTutor.test(filePath)) {
				var id = new RegExp(idPattern).exec(filePath);
				console.log("Finding a tutor with id: " + id);
				tutor.getTutor(request, response, id);
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
			} else if (filePath === "/tutors") {
				var reqBody = '';
				request.on("data", function (data) {
					reqBody += data;
				});
				console.log(reqBody);
				request.on("end", function () {
					tutor.addTutor(request, response, reqBody);
				});
			}
			else {
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
			} else if (filePath === "/tutors") {
				var reqBody = '';
				request.on("data", function (data) {
					reqBody += data;
				});
				request.on("end", function () {
					tutor.updateTutor(request, response, reqBody);
				});
			}
			else {
				msg.show404(request, response, "Internal Error");
			}
			break;
		case "DELETE":
			if (filePath === "/students" || ptn.test(filePath)) {
				var id = new RegExp(idPattern).exec(filePath);
				student.deleteStudent(request, response, { "id": id });

			} else if (filePath === "/tutors" || ptnTutor.test(filePath)) {
				var id = new RegExp(idPattern).exec(filePath);
				tutor.deleteTutor(request, response, { "id": id });
			} else {
				console.log(request);
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
	var base = './src/static';
	var extname = path.extname(filePath);
	var contentType = 'text/html';

	if (filePath === '/') {
		filePath = './src/index.html';
	} else {
		switch (extname) {
			case '.js':
				contentType = 'text/javascript';
				break;
			case '.css':
				contentType = 'text/css';
				break;
			default:
				contentType = "text/plain";
		}
		filePath = "." + filePath;
	}
	console.log('[request] ' + filePath);

	fs.readFile(filePath, function (error, content) {
		if (error) {
			msg.show404(request, response, error);
		} else {
			msg.show200(request, response, content, contentType);
		}
	});
}