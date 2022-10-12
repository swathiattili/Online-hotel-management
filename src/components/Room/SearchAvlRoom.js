import React,{useState} from 'react'
import { TextField } from '@material-ui/core'
import { Button } from '@material-ui/core'
import { makeStyles } from '@material-ui/core'
import RoomService from '../../services/RoomService'
import { Link } from 'react-router-dom'



const useStyles=makeStyles({
    search:{
        width:1000,
    }
})


export default function SearchAvlRoom() {
    
    const classes=useStyles()
    const [Rooms, setRooms] = useState([]);
    const [roomAvailable, setRoomAvailable] = useState('');
    const getAvailRooms=()=>{
        RoomService.getAvailableRooms(roomAvailable).then((response)=>{
            setRooms(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    };
    return (
        <>
        
            <div style={{marginTop:100, maxWidth: "100%", width: "80%" }} className='container'>
           <br></br><br></br>
           <h1>Search for Rooms</h1> 
           <TextField variant="outlined" label="Search Rooms" placeholder='Enter true for searching available rooms'
                className={classes.search} value={roomAvailable} onChange={(e)=>setRoomAvailable(e.target.value)}>
            </TextField>
            <br></br><br></br>
            <a  className="btn btn-success float-centre" onClick={()=>getAvailRooms()} >
          Search Rooms
        </a>&nbsp;&nbsp;&nbsp;
           

            <div className="container">
        <br></br>
        <br></br>
        <h1>List Of Rooms Available</h1>

        <br></br>
        <br></br>
        <div>
          <div>
            <table>
              <thead>
                <tr>
                    <th>Room Number</th>
                        <th>Room Type</th>
                        <th>Room Rent</th>
                        <th>Room Available</th>
                        <th>Actions</th>
                </tr>
              </thead>
              <tbody>
              {
                        Rooms.map(
                            roomDetails=>
                                <tr key={roomDetails.roomId}>
                                    <td>{roomDetails.roomId}</td>
                                    <td>{roomDetails.roomType}</td>
                                    <td>{roomDetails.roomRent}</td>
                                    {/* <td>{roomDetails.roomAvailable}</td> */}
                                    <td>{String(roomDetails.roomAvailable)}</td>
                                    <td>
                                       
                                        &nbsp;&nbsp;
                                        <a href="/middle/groom/addGuest" className="btn btn-success float-centre" >
          Add Guest
        </a>
                                    </td>
                                </tr>
                        )
                    }
              </tbody>
            </table>
          </div>
        </div>
        </div>
        </div>
       
        </>
    )
}
