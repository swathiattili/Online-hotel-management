import React from 'react'
import SingleRoom from '../Images/Single Room.jpg'
import DoubleRoom from '../Images/Double Bed room.png'
import QueenRoom from '../Images/Queen Room.jpg'
import KingRoom from '../Images/King Room.jpg'
import ExecutiveRoom from '../Images/Queen room 2.jpg'
import LuxuryRoom from '../Images/Luxury Room 1.jpg'
import SingleRoom1 from '../Images/Single room 1.jpg'


const OurRooms = () => {
    return(
        <div className="our_room_container">
        <div className="our_room_heading">
            <h1 >Our Rooms</h1>
        </div>
        <div className="room_row">
                <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={SingleRoom} alt="Single Room"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Single Room</h2>
                            <p>Rs. 1000/Night**</p>
                        </div>
                    </div>
                </div>
                    <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={DoubleRoom}  alt="Double Bed Room"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Double Bed Room</h2>
                            <p>Rs. 1500/Night**</p>
                        </div>
                    </div>
                </div>
                    <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={QueenRoom}  alt="Queen Room"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Queen Room</h2>
                            <p>Rs. 5000/Night**</p>
                        </div>
                    </div>
                </div>
                    <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={KingRoom}  alt="King Room"></img>
                        </div>
                        <div className="room_caption">
                            <h2>King Room</h2>
                            <p>Rs. 6000/Night**</p>
                        </div>
                    </div>
                </div>
                 <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={ExecutiveRoom} alt="Queen room 2"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Executive Suite</h2>
                            <p>Rs. 4000/Night**</p>
                        </div>
                    </div>
                </div>
                                <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={LuxuryRoom}  alt="Luxury Room 1"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Luxury Room</h2>
                            <p>Rs. 8000/Night**</p>
                        </div>
                    </div>
                </div>
                    <div className="col-xl-4 col-lg-6 col-md-6">
                    <div className="room mb-50">
                        <div className="room_image">
                            <img src={SingleRoom1}  alt="Single room 1"></img>
                        </div>
                        <div className="room_caption">
                            <h2>Luxury Single Room</h2>
                            <p>Rs. 2000/Night**</p>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    )
}
export default OurRooms