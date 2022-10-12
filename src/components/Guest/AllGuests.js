import { Button } from '@material-ui/core'
import React,{useState,useEffect} from 'react'
import GuestService from '../../services/GuestService'
import '../Room/AllRooms.css'
import { useHistory } from 'react-router-dom'


export default function AllGuests() {

    const [guest, setGuest] = useState([])
 
    const history = useHistory();
    
    useEffect(() => {
        getAllGuests()
    }, [])
    const getAllGuests=()=>{
        GuestService.getAllGuests().then((response)=>{
            setGuest(response.data)
          
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    };
    const deleteGuest=(guestId)=>{
        GuestService.deleteGuest(guestId).then((response)=>{
            console.log(guestId);
            getAllGuests();   
        }).catch(error => {
            console.log(error);
        })
    }
    
    return (
        <>
       
            <div style={{ maxWidth: "100%", width: "80%" }} className='container'   >
            <br></br><br></br><br></br>
            <h1>Guests List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Guest ID</th>
                        <th>Guest Name</th>
                        <th>Guest Contact</th>
                        <th>Guest Email</th>
                        <th>Guest Gender</th>
                        <th>Guest Address</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        guest.map(
                            guestDetails=>
                                <tr key={guestDetails.guestId}>
                                    <td>{guestDetails.guestId}</td>
                                    <td>{guestDetails.guestName}</td>
                                    <td>{guestDetails.guestContact}</td>
                                    <td>{guestDetails.guestEmail}</td>
                                    <td>{guestDetails.guestGender}</td>
                                    <td>{guestDetails.guestAddress}</td>
                                    <td>
                                    <a  className="btn btn-success float-centre" onClick={()=>deleteGuest(guestDetails.guestId)} >
          Delete
        </a>
       
                                    </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
       
        </>
    )
}