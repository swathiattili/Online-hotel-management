import { Button } from '@material-ui/core'
import React,{useState,useEffect} from 'react'
import StaffService from '../../services/StaffService'
import '../Room/AllRooms.css'


export default function AllStaff() {

    const [staff, setStaff] = useState([])
    // for Rest API call 
    useEffect(() => {
        getAllStaffs()
    }, [])
    const getAllStaffs=()=>{
        StaffService.getAllStaffs().then((response)=>{
            setStaff(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    };
    const deleteStaff=(staffId)=>{
        StaffService.deleteStaff(staffId).then((response)=>{
            console.log(staffId);
            getAllStaffs();   
        }).catch(error => {
            console.log(error);
        })
    }
    return (
        <>
       
            <div style={{ maxWidth: "100%", width: "90%" }} className='container'>
            <br></br><br></br><br></br>
            <h1>Staff List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Staff ID</th>
                        <th>Staff Name</th>
                        <th>Staff Salary</th>
                        <th>Staff Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        staff.map(
                            staffDetails=>
                                <tr key={staffDetails.staffId}>
                                    <td>{staffDetails.staffId}</td>
                                    <td>{staffDetails.staffName}</td>
                                    <td>{staffDetails.staffSalary}</td>
                                    <td>{staffDetails.staffEmail}</td>
                                    <td>
                                    <a  className="btn btn-success float-centre" onClick={()=>deleteStaff(staffDetails.staffId)} >
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
