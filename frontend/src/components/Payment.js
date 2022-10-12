import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import PaymentService from '../services/PaymentService'
import { Link, useHistory } from 'react-router-dom'


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
export default function Payment() {
    const [price, setPrice] = useState('')
    const [currency, setCurrency] = useState('')
    const [method, setMethod] = useState('')
    const [intent, setIntent] = useState('')
    const [description, setDescription] = useState('')
    
    const history=useHistory()

    const successPayment =(e)=>{
    e.preventDefault();

    const payment={price,currency,method,intent,description}
    PaymentService.getPayment(payment).then((response)=>{
        console.log(response.data)
         window.open("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token=EC-49A51018Y5115781S", "_blank");

    /*    history.push('/middle/resroom')*/
    }).catch(error=>{
        console.log(error)
    })
}

const classes=useStyles()
return (
    <>
    
        <div style={{ marginTop: 100, maxWidth: "100%", width: "80%" }} className='container'>
        <br></br><br></br>
        <h1>Enter Payment Details</h1>
        <TextField variant="outlined" label="Price" placeholder='Enter a Price' 
            className={classes.price} value={price} onChange={(e)=>setPrice(e.target.value)}>
        </TextField>
        <br></br><br></br>
        <TextField variant="outlined" label="Currency" placeholder='Enter the Currency'
            className={classes.currency} value={currency} onChange={(e)=>setCurrency(e.target.value)}>
        </TextField>
        <br></br><br></br>
        <TextField variant="outlined" label="Method" placeholder='Enter the Method'
            className={classes.method} value={method} onChange={(e)=>setMethod(e.target.value)}>
        </TextField>
        <br></br><br></br>
        <TextField variant="outlined" label="Intent" placeholder='Enter the Intent'
            className={classes.intent} value={intent} onChange={(e)=>setIntent(e.target.value)}>
        </TextField>
        <br></br><br></br>
        <TextField variant="outlined" label="Description" placeholder='Enter the Description'
            className={classes.description} value={description} onChange={(e)=>setDescription(e.target.value)}>
        </TextField>
       
        <br></br><br></br>
        <Button variant='contained' onClick={(e)=>successPayment(e)}>Continue to CheckOut</Button>&nbsp;&nbsp;&nbsp;
        <Button variant='outlined'><Link to='/middle/resroom'>Back</Link></Button>
    </div>
  
    </>
)
}
