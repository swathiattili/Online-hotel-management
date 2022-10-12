import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'

import { makeStyles } from '@material-ui/core'
import ReservationService from '../../services/ReservationService'
import {  useHistory } from 'react-router-dom'
import Calendar from 'react-calendar'
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';

const useStyles=makeStyles({
    resid:{
        width:1000,
    },
    rid:{
        width:1000
    },
    gid:{
        width:1000
    },
    checkin:{
        width:1000
    },
    checkout:{
        width:1000
    },
    numguest:{
        width:1000
    },
    price:{
        width:1000
    }
})
export default function AddReservation() {
    const [reservationId, setReservationId] = useState('')
    const [roomId, setRoomId] = useState('')
    const [guestId, setGuestId] = useState('')
    const [checkInDate, setCheckInDate] = useState('')
    const [checkOutDate, setCheckOutDate] = useState('')
    const [numOfGuest, setNumOfGuest] = useState('')
    const [totalPrice, setTotalPrice] = useState('')
    const history=useHistory()


    const required = (values) => {
        
        if (values ==="") {
            return (
                <div className="alert alert-danger" role="alert">
                  
                </div>
              );
            }
      };
      

    const saveReservation =(e)=>{
    e.preventDefault();

    const reservation={reservationId,roomId,guestId,checkInDate,checkOutDate,numOfGuest,totalPrice}
    ReservationService.addReservations(reservation).then((response)=>{
        console.log(response.data)
        history.push('/middle/resroom')
    }).catch(error=>{
        console.log(error)
    })
}
    const classes=useStyles()
    return (
       
        
            <div style={{ marginTop: 100, maxWidth: "100%", width: "80%" }} className='container'>
               
            <br></br><br></br>
            <a href="/middle/hroom/getAvail" className="btn btn-success text-centre float-right" >
          View Rooms
        </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/middle/groom/getAllGuest" className="btn btn-success float-centre" >
          View Guests
        </a>
            <h1>Enter Reservation Details</h1>
           
            <br></br><br></br>
            <TextField variant="outlined" label="Room ID" placeholder='Enter the Room Id'
                className={classes.rid} value={roomId} onChange={(e)=>setRoomId(e.target.value)} error={required(roomId)} helperText ={required(roomId)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Guest ID" placeholder='Enter the Guest Id'
                className={classes.gid} value={guestId} onChange={(e)=>setGuestId(e.target.value)} error={required(guestId)} helperText ={required(guestId)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker 
             label="Check In Date"
             value={checkInDate}
        onChange={(newValue) => {
          setCheckInDate(newValue);
        }}
        renderInput={(params) =>
            <TextField {...params} variant="outlined" 
                className={classes.checkin} value={checkInDate} error={required(checkInDate)} helperText ={required(checkInDate)?"This field is required":""}>
            </TextField>}
            />
            </LocalizationProvider>
            <br></br><br></br>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker 
             label="Check Out Date"
             value={checkOutDate}
        onChange={(newValue) => {
          setCheckOutDate(newValue);
        }}
        renderInput={(params) =>
            <TextField {...params} variant="outlined" label="CheckOut Date" placeholder='Enter the CheckOut Date'
                className={classes.checkout} value={checkOutDate}   error={required(checkOutDate)} helperText ={required(checkOutDate)?"This field is required":""}>
            </TextField>}
            />
            </LocalizationProvider>
            <br></br><br></br>
            <TextField variant="outlined" label="Number of Guest" placeholder='Enter the number of guest'
                className={classes.numguest} value={numOfGuest} onChange={(e)=>setNumOfGuest(e.target.value)}  error={required(numOfGuest)} helperText ={required(numOfGuest)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Total Price" placeholder='Enter the total price'
                className={classes.price} value={totalPrice} onChange={(e)=>setTotalPrice(e.target.value)} error={required(totalPrice)} helperText ={required(totalPrice)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre" onClick={(e)=>saveReservation(e)} >
          Add Reservation
        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/middle/resroom" className="btn btn-success float-centre" >
          Back
        </a>
        </div>
        
      
     
    )
}