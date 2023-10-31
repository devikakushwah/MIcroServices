const mongoose = require('mongoose');
const StaffSchema = new mongoose.Schema({
    staffName : {
        type: String
    },
    staffId : {
        type: String
    },
    phoneNumber :{
        type : String
    },
    address : {
        type: String
    },
    role :{
       type : String
    },
    hotelId :{
        type: String
    },
    date:{
        type:Date,
        default:Date.now
    }

});

module.exports = mongoose.model('staff', StaffSchema);