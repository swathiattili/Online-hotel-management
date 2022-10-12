import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import InventoryService from '../../services/InventoryService'
import { Link, useHistory } from 'react-router-dom'


const useStyles=makeStyles({
    id:{
        width:1000
    },
    type:{
        width:1000
    },
    name:{
        width:1000
    },
    stock:{
        width:1000
    }
})
export default function AddInventory() {
    const [inventoryId, setInventoryId] = useState('')
    const [inventoryType, setInventoryType] = useState('')
    const [inventoryName, setInventoryName] = useState('')
    const [inventoryStock, setInventoryStock] = useState('')
    const history=useHistory()

    const required = (values) => {
        
        if (values ==="") {
            return (
                <div className="alert alert-danger" role="alert">
                  
                </div>
              );
            }
      };


    const saveInventory =(e)=>{
    e.preventDefault();

    const inventory={inventoryId,inventoryType,inventoryName,inventoryStock}
    InventoryService.addInventory(inventory).then((response)=>{
        console.log(response.data)
        history.push('/middle/iroom')
    }).catch(error=>{
        console.log(error)
    })
}
    const classes=useStyles()
    return (
        <>
        
            <div style={{ marginTop: 100, maxWidth: "100%", width: "80%" }} className='container'>
            <br></br><br></br>
            <h1>Enter Inventory Details</h1>
           
            <br></br><br></br>
            <TextField variant="outlined" label="Inventory Type" placeholder='Enter the type of inventory'
                className={classes.type} value={inventoryType} onChange={(e)=>setInventoryType(e.target.value)}  error={required(inventoryType)} helperText ={required(inventoryType)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Inventory Name" placeholder='Enter the name of inventory'
                className={classes.name} value={inventoryName} onChange={(e)=>setInventoryName(e.target.value)}  error={required(inventoryName)} helperText ={required(inventoryName)?"This field is required":""}> 
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Inventory Stock" placeholder='Enter the stock of inventory'
                className={classes.stock} value={inventoryStock} onChange={(e)=>setInventoryStock(e.target.value)}  error={required(inventoryStock)} helperText ={required(inventoryStock)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre"  onClick={(e)=>saveInventory(e)}>
          Add Inventory
        </a>&nbsp;&nbsp;&nbsp;
        <a href="/middle/iroom" className="btn btn-success float-centre" >
          Back
        </a>
        </div>
        
        </>
    )
}