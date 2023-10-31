const express = require("express");
const app  =  express();
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const staffRoute = require('./routes/staff.route');
const eurekaHelper = require("./eureka.helper");

mongoose.connect("mongodb+srv://devikakushwah:Radhakrishna%4029@newcluster.7o13k.mongodb.net/microservice?retryWrites=true&w=majority");

app.use(bodyParser.urlencoded({ extended:true}));
app.use(bodyParser.json());

app.use('/staff', staffRoute);
const port = process.env.PORT || 8088;

eurekaHelper.registerWithEureka("STAFF-SERVICE", port);
app.listen(port,() =>{
    console.log("server running on = ", port);
})