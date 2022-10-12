import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import About from './About';
import Contact from './Contact';
import Footer from './Footer';
import AddGuest from './Guest/AddGuest';
import AllGuests from './Guest/AllGuests';
import HomeGuest from './Guest/HomeGuest';

import Home from './Home';
import AddInventory from './Inventory/AddInventory';
import AllInventory from './Inventory/AllInventory';
import HomeInventory from './Inventory/HomeInventory';
import ManagerProfile from './ManagerProfile';
import MiddleLayout from './MiddleLayout';
import Payment from './Payment';
import Receptionist from './Receptionist';
import AddReservation from './Reservation/AddReservation';
import AllReservations from './Reservation/AllReservation';
import HomeReservation from './Reservation/HomeReservation';
import AddRoom from './Room/AddRoom';
import AllRooms from './Room/AllRooms';
import HomeRoom from './Room/HomeRoom';
import SearchAvlRoom from './Room/SearchAvlRoom';

import SignIn from './SignIn';
import SignUp from './SignUp';
import AddStaff from './Staff/AddStaff';
import AllStaff from './Staff/AllStaff';
import HomeStaff from './Staff/HomeStaff';

function Navbarcomp() {

       return (
        <Router>
    <Navbar bg="dark" variant='dark' expand="lg">
      <Container>
        <Navbar.Brand href="/home">Online Hotel Management System</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to={'/home'}>Home</Nav.Link>
            <Nav.Link as={Link} to={'/sign-in'}>Sign In</Nav.Link>
            <Nav.Link as={Link} to={'/sign-up'}>Sign Up</Nav.Link>
            <Nav.Link as={Link} to={'/about'}>About</Nav.Link>
            <Nav.Link as={Link} to={'/contact'}>Contact</Nav.Link>
            
        
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    <div>
    <Switch>
          <Route path="/home">
            <Home/>
          </Route>
          <Route path="/sign-in">
            <SignIn/>
          </Route>
          <Route path="/sign-up">
            <SignUp/>
          </Route>
          <Route path="/about">
            <About/>
          </Route>
          <Route path="/contact">
            <Contact/>
          </Route>
          <Route path="/manager">
            <ManagerProfile/>
          </Route>
          <Route path='/middle' exact component={MiddleLayout}/>
          <Route path='/middle/hroom' exact component={HomeRoom}/>
          <Route path='/middle/hroom/addRoom' exact component={AddRoom}/>
          <Route path='/middle/hroom/getAllRoom' exact component={AllRooms}/>
          <Route path='/middle/hroom/getAvail' exact component={SearchAvlRoom}/>
          <Route path='/middle/groom' exact component={HomeGuest}/>
          <Route path='/middle/groom/addGuest' exact component={AddGuest}/>
          <Route path='/middle/groom/getAllGuest' exact component={AllGuests}/>
          <Route path='/middle/resroom' exact component={HomeReservation}/>
          <Route path='/middle/resroom/addReservation' exact component={AddReservation}/>
          <Route path='/middle/resroom/getAllReservation' exact component={AllReservations}/>
          <Route path='/middle/iroom' exact component={HomeInventory}/>
          <Route path='/middle/iroom/addInventory' exact component={AddInventory}/>
          <Route path='/middle/iroom/getAllInventory' exact component={AllInventory}/>
          <Route path='/middle/sroom' exact component={HomeStaff} />
          <Route path='/middle/sroom/addStaff' exact component={AddStaff} />
          <Route path='/middle/sroom/getAllStaff' exact component={AllStaff} />
          <Route path='/payment' exact component={Payment} />
          <Route path='/manager' exact component={ManagerProfile} />
          <Route path='/receptionist' exact component={Receptionist} />
         
        </Switch>
        <Footer></Footer>
    </div>
    
    </Router>
  );
}

export default Navbarcomp
