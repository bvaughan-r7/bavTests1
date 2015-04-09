

function miniCRMSDK(template, dictionary) {
	//console.log(template);
	// console.log(dictionary);
	
	for(var key in dictionary) {
		console.log("key: " + key + "  value: " + dictionary[key]);
		template = template.replace(new RegExp(key, 'g'), dictionary[key]);
	}
	return template;
}

/* var http = require('http');
http.createServer(function handler(req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World\n');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
 */

// Open script file and read contents
var fs = require('fs');
fs.readFile('.\\CRMSDKscript.txt', 'utf8', function (err,template) {
  if (err) {
    return console.log(err);
  }
  //console.log(template);

  //Open a json file and read the results into an Array.
  var fs2 = require('fs');
  fs2.readFile('.\\CRMSDKsubstitutes.json', 'utf8', function (err, dictData) {
  	if (err) {
	  return console.log(err);
	}
  	var dict = JSON.parse(dictData);
  	//console.log(dictData);
  	var document = miniCRMSDK(template, dict);
  	
  	console.log(document);
  });
});

var x = "place to break";


// Call function to make the substitutions and return the results
// as a string

// print the results out to the console.