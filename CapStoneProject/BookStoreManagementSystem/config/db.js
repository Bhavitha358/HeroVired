const mongoose = require("mongoose");

mongoose.connect('mongodb+srv://yogeshwar1710a:yogeshwar17@cluster0.moxfbyl.mongodb.net/BookStore');

const db = mongoose.connection;

db.on('error',(error)=>{
    console.log('error to connecting with database')
})

db.once('open',function(){
    console.log('Successfully connected to database');
})