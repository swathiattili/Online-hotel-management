import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import StaffService from '../../services/StaffService'
import { Link, useHistory } from 'react-router-dom'
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
export default function AddStaff() {
    const [staffId, setStaffId] = useState('')                 //It initialize the state by calling useState in the function AddRoom ..guestId-current state , setGuestId-updated state
    const [staffName, setStaffName] = useState('')
    const [staffSalary, setStaffSalary] = useState('')
    const [staffEmail, setStaffEmail] = useState('')
    const history=useHistory()
    
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


    const saveStaff =(e)=>{
    e.preventDefault();

    const staff={staffId,staffName,staffSalary,staffEmail}
    StaffService.addStaffs(staff).then((response)=>{
        console.log(response.data)
        history.push('/middle/sroom')
    }).catch(error=>{
        console.log(error)
    }) 
}
    const classes=useStyles()
    return (
        <>
        
            <div style={{ marginTop: 100, maxWidth: "100%", width: "80%" }} className='container'>
            <br></br><br></br>
            <h1>Enter Staff Details</h1>
            <TextField variant="outlined" label="Staff ID" placeholder='Enter a Staff Id' className={classes.id}
                value={staffId} onChange={(e)=>setStaffId(e.target.value)}  error={required(staffId)} helperText ={required(staffId)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Staff Name" placeholder='Enter the staff name'
                className={classes.name} value={staffName} onChange={(e)=>setStaffName(e.target.value)}  error={required(staffName)} helperText ={required(staffName)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Staff Slary" placeholder='Enter the salary of staff'
                className={classes.salary} value={staffSalary} onChange={(e)=>setStaffSalary(e.target.value)}  error={required(staffSalary)} helperText ={required(staffSalary)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Staff Email" placeholder='Enter the email of staff'
                className={classes.email} value={staffEmail} onChange={(e)=>setStaffEmail(e.target.value)}  error={required(staffEmail)} helperText ={[required(staffEmail)?"This field is required":""] && [vEmail(staffEmail)?"Enter valid Email":""]} >
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre" onClick={(e)=>saveStaff(e)} >
          Add Room
        </a>&nbsp;&nbsp;&nbsp;
        <a href="/middle/hroom" className="btn btn-success float-centre" >
          Back
        </a>
        </div>
       
        </>
    )
}
