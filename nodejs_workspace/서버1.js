let http = require("http");

const hostname = "127.0.0.1";
const port = 4000;

const server = http.createServer( (req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/html');
    res.end('<h1>Hello word</h1>');
});

server.listen( port, hostname, () => {
    // 백틱 `
    console.log(`server running at http://${hostname}:${port}`);
})