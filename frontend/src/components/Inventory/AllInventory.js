import { Button } from '@material-ui/core'
import React,{useState,useEffect} from 'react'
import InventoryService from '../../services/InventoryService'
import '../Room/AllRooms.css'


export default function AllInventory() {

    const [inventory, setInventory] = useState([])
    // for Rest API call 
    useEffect(() => {
        getAllInventorys()
    }, [])
    const getAllInventorys=()=>{
        InventoryService.getAllInventory().then((response)=>{
            setInventory(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    };
    const deleteInventory=(inventoryId)=>{
        InventoryService.deleteInventory(inventoryId).then((response)=>{
            console.log(inventoryId);
            getAllInventorys();
        }).catch(error => {
            console.log(error);
        })
    }
    return (
        <>
        
            <div style={{ maxWidth: "100%", width: "90%" }} className='container'>
            <br></br><br></br><br></br>
            <h1>Inventory List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Inventory ID</th>
                        <th>Inventory Type</th>
                        <th>Inventory Name</th>
                        <th>Inventory Stock</th>
                        <th>Works</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        inventory.map(
                            inventoryDetails=>
                                <tr key={inventoryDetails.inventoryId}>
                                    <td>{inventoryDetails.inventoryId}</td>
                                    <td>{inventoryDetails.inventoryType}</td>
                                    <td>{inventoryDetails.inventoryName}</td>
                                    <td>{inventoryDetails.inventoryStock}</td>
                                    <td>
                                    <a  className="btn btn-success float-centre" 
                                        onClick={()=>deleteInventory(inventoryDetails.inventoryId)} >
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
