import React, { Component } from 'react'
import contactpic from '../Images/lobby.jpg'

export default class Contact extends Component {
  render() {
    return (
      <div className='contact_container1' style={{marginTop:100}}>
        <h1>Contact Us</h1>
        <div className='contact_container2'>
          <div className='Contact_container3'>
          <h3>Phone Number:+91 1234567890</h3>
          <p>Incase the about number is not available, you can also contact us throught the below phone  number</p>
          <p>+91 9876543210</p>
          <p>Mail Id:hotelmanagement@gmail.com</p>
          </div>
          <div className='contact_container4'>
          <img src={contactpic} alt="lobby"/>
          </div>
        </div>
        
      </div>
      
    )
  }
}

