import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import GuestService from '../../services/GuestService'
import { Link } from 'react-router-dom'
import { useHistory } from 'react-router-dom'
import { isEmail } from "validator";


const useStyles=makeStyles({
    id:{
        width:1000
    },
    name:{
        width:1000
    },
    contact:{
        width:1000
    },
    email:{
        width:1000
    },
    gender:{
        width:1000
    },
    address:{
        width:1000
    }
})
export default function AddGuest() {
    const [guestId, setGuestId] = useState('')                 //It initialize the state by calling useState in the function AddRoom ..guestId-current state , setGuestId-updated state
    const [guestName, setGuestName] = useState('')
    const [guestContact, setGuestContact] = useState('')
    const [guestEmail, setGuestEmail] = useState('')
    const [guestGender, setGuestGender] = useState('')
    const [guestAddress, setGuestAddress] = useState('')
    const history = useHistory();



    
    const required = (values) => {
        
        if (values ==="") {
            return (
                <div className="alert alert-danger" role="alert">
                  
                </div>
              );
            }
      };

      const vEmail = (values) => {
        
        if (!isEmail(values)) {
            return (
                <div className="alert alert-danger" role="alert">
                  
                </div>
              );
            }
      };

    const saveGuest =(e)=>{
    e.preventDefault();
    
    const guest={guestId,guestName,guestContact,guestEmail,guestGender,guestAddress}
   
    GuestService.addGuests(guest).then((response)=>{
        console.log(response.data)
         history.push('/middle/groom')
    }).catch(error=>{
        console.log(error)
    })
    
}
    const classes=useStyles()
    return (
        <>
        
            <div style={{ marginTop: 100, maxWidth: "100%", width: "80%" }} className='container'>
            <br></br><br></br>
            <h1>Enter Guest Details</h1>
          
            <br></br><br></br>
            <TextField required variant="outlined" label="Guest Name" placeholder='Enter the guest name'
                className={classes.name} 
                value={guestName} 
                onChange={(e)=>setGuestName(e.target.value)} 
                error={required(guestName)} 
                helperText ={required(guestName)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField required variant="outlined" label="Guest Contact" placeholder='Enter the contact of guest'
                className={classes.contact} value={guestContact} onChange={(e)=>setGuestContact(e.target.value)} error={required(guestContact)} helperText ={required(guestContact)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField required variant="outlined" label="Guest Email" placeholder='Enter the email of guest'
                className={classes.email} value={guestEmail} onChange={(e)=>setGuestEmail(e.target.value)}  error={required(guestEmail)} helperText ={[required(guestEmail)?"This field is required":""] && [vEmail(guestEmail)?"Enter valid Email":""]}  >
            </TextField>
            <br></br><br></br>
            <TextField required variant="outlined" label="Guest Gender" placeholder='Enter the gender of guest'
                className={classes.gender} value={guestGender} onChange={(e)=>setGuestGender(e.target.value)}  error={required(guestGender)} helperText ={required(guestGender)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField required variant="outlined" label="Guest Address" placeholder='Enter the address of guest'
                className={classes.address} value={guestAddress} onChange={(e)=>setGuestAddress(e.target.value)}  error={required(guestAddress)} helperText ={required(guestAddress)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre" onClick={(e)=>saveGuest(e)}>
          Add Guest
        </a>&nbsp;&nbsp;&nbsp;
            <a href="/middle/resroom/addReservation" className="btn btn-success float-centre" >
          Add Reservation
        </a>&nbsp;&nbsp;&nbsp;
            <a href="/middle/hroom" className="btn btn-success float-centre" >
          Back
        </a>
        </div>
        
        </>
    )
}

