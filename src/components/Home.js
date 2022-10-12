import React, { Component } from 'react'
//import lobby1 from '../Images/lobby1.jpg'
import Video from '../Images/Video.mp4'
//import Footer from './Footer'

import OurRooms from './OurRooms'


export default class Home extends Component {
  render() {
    return (
    

      <div className='Home_Container'>
        
        <div><video id='img1' src={Video} autoPlay loop muted/>
        <div className='content'>
            <h1>Welcome</h1>
            <h2>Online Hotel Management</h2>
        </div>
        </div>
          <div className='container'>
            <OurRooms/>
          </div>
         
      </div>
       
     
    )
  }
}

