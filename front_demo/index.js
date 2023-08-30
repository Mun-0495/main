const express = require('express');
const app = express();
const port = 3000;
const indexrouter = require('./router/indexrouter');
const path = require('path')

app.use('/', indexrouter);

app.use((req, res, next) => {
    res.status(404).sendFile(path.join(__dirname, 'err', '404.html'))
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})