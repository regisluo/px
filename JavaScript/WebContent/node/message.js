var settings = require('./settings');

exports.show500 = function (request, response, error) {
    if (settings.msgFormat === "JSON") {
        response.writeHead(500, { 'Content-Type': 'application/json' });
        response.end(JSON.stringify({ "data": "Internal ERROR " + error }));
    } else {
        response.writeHead(500, { 'Content-Type': 'text/html' });
        response.end("<h2>500: Internal Error:</h2>" + error);
    }
};

exports.show200 = function (request, response, data, contentType) {
    response.writeHead(200, { 'Content-Type': contentType });
    response.end(data, 'utf-8');
};

exports.sendJson = function (request, response, data) {
    response.writeHead(200, { 'Content-Type': 'application/json' });
    response.end(data, 'utf-8');
};

exports.show405 = function (request, response, error) {
    if (settings.msgFormat === "JSON") {
        response.writeHead(405, { 'Content-Type': 'application/json' });
        response.end(JSON.stringify({ "data": "405 Method Not Supported " + error }));
    } else {
        response.writeHead(405, { 'Content-Type': 'text/html' });
        response.end("<h2>405: Method Not Supported!</h2>");
    }
};

exports.show404 = function (request, response, error) {
    if (settings.msgFormat === "JSON") {
        response.writeHead(404, { 'Content-Type': 'application/json' });
        response.end(JSON.stringify({ "data": "Page Not Found " + error }));
    } else {
        response.writeHead(404, { 'Content-Type': 'text/html' });
        response.end("<h2>404: Page Not Found!</h2>");
    }
};