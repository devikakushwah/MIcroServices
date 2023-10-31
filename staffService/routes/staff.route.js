const express = require('express');
const router = express.Router();
const { check, validationResult } = require('express-validator');
const staffController = require('../controller/staff.controller');

router.get('/welcome',(request, response) => {
    response.status(200).json({msg:"successFully saved"});

})

router.get('/hotel/:hotelId',staffController.getStaffByHotelId);

router.post(
    '/add',
    check('staffName', 'Name is required').notEmpty(),
    // auth,
    staffController.saveStaffInfo);
  
  module.exports = router;