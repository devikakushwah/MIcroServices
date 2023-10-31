
const { validationResult } = require('express-validator');
const StaffSchema = require('../model/staff.model');

exports.saveStaffInfo = async (request, response) => {
    const errors = validationResult(request);
    if (!errors.isEmpty()) {
      return response.status(400).json({ errors: errors.array() });
    }
    const { staffName, staffId, phone_number ,address, role, hotelId } = request.body;

    try {
      let staff = await StaffSchema.findOne({ staffId });

      if (staff) {
        return response
          .status(400)
          .json({ errors: [{ msg: 'Staff already exists' }] });
      }
      staff = new StaffSchema({
          staffName,
          staffId,
          phone_number,
          address,
          role,
          hotelId
      });
      await staff.save();
      response.status(400).json({msg:"successFully saved"});
    } catch (err) {
      console.error(err.message);
      response.status(500).json({msg:"err"});
    }
  };

  exports.getStaffByHotelId = async (request, response) => {

    const errors = validationResult(request);
    if (!errors.isEmpty()) {
      return response.status(400).json({ errors: errors.array() });
    }
    const hotelId = request.params.hotelId;
    try {
        console.log("hotelId", hotelId)
        let staff = await StaffSchema.findOne({ hotelId });
  
        if (staff) {
          return response
            .status(200)
            .json([ staff ]);
        }else{
            return response
            .status(200)
            .json([{ msg: 'Not found Staff Info' , staff : staff} ]);
        }
      } catch (err) {
        console.error(err.message);
        response.status(500).json({msg:"err"});
      }
  };