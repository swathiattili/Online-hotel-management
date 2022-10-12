import React,{ useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import RoomService from '../../services/RoomService'
import { Link, useHistory } from 'react-router-dom'


const useStyles=makeStyles({
    id:{
        width:1000,
    },
    type:{
        width:1000
    },
    rent:{
        width:1000
    },
    available:{
        width:1000
    }
})
export default function AddRoom() {
    const [roomId, setRoomId] = useState('')
    const [roomType, setRoomType] = useState('')
    const [roomRent, setRoomRent] = useState('')
    const [roomAvailable, setRoomAvailable] = useState('')
    const history=useHistory()


    const required = (values) => {
        
        if (values ==="") {
            return (
                <div className="alert alert-danger" role="alert">
                  
                </div>
              );
            }
      };

    const saveRoom =(e)=>{
    e.preventDefault();

    const room={roomId,roomType,roomRent,roomAvailable}
    RoomService.addRooms(room).then((response)=>{
        console.log(response.data)
        history.push('/middle/hroom')
    }).catch(error=>{
        console.log(error)
    })
}
    const classes=useStyles()
    return (
        <>
            
            <div style={{ maxWidth: "100%", width: "50%", marginTop: 100 }} className='container'>
            <br></br><br></br>
            <h1>Enter Room Details</h1>
            <TextField variant="outlined" label="Room ID" placeholder='Enter a Room Id' className={classes.id}
                value={roomId} onChange={(e)=>setRoomId(e.target.value)} error={required(roomId)} helperText ={required(roomId)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Room Type" placeholder='Enter the type of room'
                className={classes.type} value={roomType} onChange={(e)=>setRoomType(e.target.value)}  error={required(roomType)} helperText ={required(roomType)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Room Rent" placeholder='Enter the rent of room'
                className={classes.rent} value={roomRent} onChange={(e)=>setRoomRent(e.target.value)}  error={required(roomRent)} helperText ={required(roomRent)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <TextField variant="outlined" label="Room Available" placeholder='Enter the availability of room (true/false)'
                className={classes.available} value={roomAvailable} onChange={(e)=>setRoomAvailable(e.target.value)}  error={required(roomAvailable)} helperText ={required(roomAvailable)?"This field is required":""}>
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre" onClick={(e)=>saveRoom(e)} >
          Add Room
        </a>&nbsp;&nbsp;&nbsp;
        <a href="/middle/hroom" className="btn btn-success float-centre" >
          Back
        </a>
        </div>
       
        </>
    )
}
