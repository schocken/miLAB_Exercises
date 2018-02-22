const express = require('express');
const fs = require('fs');
let app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req,res) => {
  const fileList = "Pick a Zeplin song to read:<br>stairway<br>immigramnt";
  res.set('Content-Type', 'text/html');
  res.status(200).send(fileList);
  return;
});

app.get('/getTime', (req,res) => {
  let date = new Date(Date.now()).toTimeString();
  res.status(200).send(`Current time: ${date}`);
  return;
});

app.get('/getFile', (req,res) => {
  const filename = req.query.filename;
  fs.readFile(`files/${filename}.txt`, (err, data) => {
    if(err){
      console.log(err);
      res.status(403).send('Failed to get file');
      return;
    }
    res.set('Content-Type', 'text/html');
    res.status(200).send(data);
  });
});

app.listen(PORT, () => {
  console.log(`listening at port ${PORT}`);
})
